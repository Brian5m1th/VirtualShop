package br.com.siteware.virtualshop.carrinho.application.service;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoResponse;
import br.com.siteware.virtualshop.carrinho.application.api.ItemCarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.application.api.ItemCarrinhoResponse;
import br.com.siteware.virtualshop.carrinho.application.repository.CarrinhoRepository;
import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import br.com.siteware.virtualshop.carrinho.domain.ItemCarrinho;
import br.com.siteware.virtualshop.produtos.application.repository.ProdutoRepository;
import br.com.siteware.virtualshop.produtos.domain.Produto;
import br.com.siteware.virtualshop.produtos.domain.PromocaoTipo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;


@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public CarrinhoResponse criaCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - criaCarrinho");
        carrinhoRequest.getItens().forEach(itemCarrinho -> produtoRepository.buscaProduto(itemCarrinho.getIdProduto()));
        Carrinho carrinho = carrinhoRepository.salvaCarrinho(new Carrinho(carrinhoRequest.getItens()));
        log.info("[finish] CarrinhoApplicationService - criaCarrinho");
        return new CarrinhoResponse(carrinho.getIdCarrinho());
    }

    @Override
    public ItemCarrinhoResponse adicionaItemCarrinho(UUID idCarrinho, ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - adicionaItemCarrinho");
        Carrinho carrinho = carrinhoRepository.buscaCarrinho(idCarrinho);
        produtoRepository.buscaProduto(itemCarrinhoRequest.getIdProduto());
        carrinho.adcionaOuSomaItem(itemCarrinhoRequest);
        carrinhoRepository.salvaCarrinho(carrinho);
        log.info("[finish] CarrinhoApplicationService - adicionaItemCarrinho");
        return new ItemCarrinhoResponse(carrinho);
    }

    @Override
    public Carrinho buscaCarrinho(UUID idCarrinho) {
        log.info("[start] CarrinhoApplicationService - buscaCarrinho");
        Carrinho carrinho = carrinhoRepository.buscaCarrinho(idCarrinho);
        validaPromocaoECalculaSubtotal(carrinho);
        log.info("[finish] CarrinhoApplicationService - buscaCarrinho");
        return carrinho;
    }

    private void validaPromocaoECalculaSubtotal(Carrinho carrinho) {
        carrinho.getItens().forEach(item -> processaItemCarrinho(item, carrinho));
        BigDecimal subtotalCarrinho = carrinho.getItens().stream()
                .map(ItemCarrinho::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        carrinho.setSubtotal(subtotalCarrinho);
    }

    private void processaItemCarrinho(ItemCarrinho item, Carrinho carrinho) {
        Produto produto = produtoRepository.buscaProduto(item.getIdProduto());
        BigDecimal precoUnitario = produto.getPreco();
        int quantidade = item.getQuantidade();
        boolean promocaoAtiva = isPromocaoAtiva(item, carrinho);
        PromocaoTipo tipoPromocao = PromocaoTipo.NENHUMA;
        BigDecimal subtotal = calcularSubtotal(precoUnitario, quantidade);
        if (promocaoAtiva && quantidade > 1) {
            subtotal = aplicarPromocao(precoUnitario, quantidade);
            tipoPromocao = getTipoPromocao(quantidade);
        }
        item.setSubtotal(subtotal);
        item.setPrecoUnitario(precoUnitario);
        item.setPromocao(tipoPromocao);
    }

    private boolean isPromocaoAtiva(ItemCarrinho item, Carrinho carrinho) {
        try {
            return (boolean) ItemCarrinho.class.getMethod("isPromocaoAtiva").invoke(item);
        } catch (Exception e) {
            return carrinho.isPromocaoAtiva();
        }
    }


    private BigDecimal calcularSubtotal(BigDecimal precoUnitario, int quantidade) {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    private BigDecimal aplicarPromocao(BigDecimal precoUnitario, int quantidade) {
        return switch (quantidade) {
            case 2 -> precoUnitario;
            case 3 -> BigDecimal.TEN;
            case 5 -> BigDecimal.valueOf(20);
            default -> calcularSubtotal(precoUnitario, quantidade);
        };
    }

    private PromocaoTipo getTipoPromocao(int quantidade) {
        return switch (quantidade) {
            case 2 -> PromocaoTipo.LEVE_2_PAGUE_1;
            case 3, 5 -> PromocaoTipo.TRES_POR_DEZ;
            default -> PromocaoTipo.NENHUMA;
        };
    }
}