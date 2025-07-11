package br.com.siteware.virtualshop.carrinho.application.service;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoResponse;
import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.application.repository.CarrinhoRepository;
import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import br.com.siteware.virtualshop.produtos.application.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
        Carrinho carrinho = carrinhoRepository.salvaCarrinho(new Carrinho(carrinhoRequest));
        log.info("[finish] CarrinhoApplicationService - criaCarrinho");
        return new CarrinhoResponse(carrinho.getIdCarrinho());
    }


}

