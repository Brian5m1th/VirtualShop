package br.com.siteware.virtualshop.carrinho.application.service;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoResponse;
import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.application.repository.CarrinhoRepository;
import br.com.siteware.virtualshop.carrinho.application.api.ItemCarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.domain.ItemCarrinho;
import br.com.siteware.virtualshop.produtos.application.repository.ProdutoRepository;
import br.com.siteware.virtualshop.produtos.domain.Produto;
import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import br.com.siteware.virtualshop.handler.APIException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;


    @Override
    public CarrinhoResponse criaCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - criaCarrinho");
        List<ItemCarrinho> itens = carrinhoRequest.getItens().stream().map(itemRequest -> {
            Produto produto = produtoRepository.buscaProdutos(itemRequest.getIdProduto());
            if (produto == null) {
                throw APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado com ID: " + itemRequest.getIdProduto());
            }
            return new ItemCarrinho(itemRequest);
        }).collect(Collectors.toList());
        Carrinho carrinho = carrinhoRepository.salvaCarrinho(new Carrinho(itens));
        log.info("[finish] CarrinhoApplicationService - criaCarrinho");
        return new CarrinhoResponse(carrinho.getIdCarrinho());
    }


}
