package br.com.siteware.virtualshop.carrinho.application.service;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoResponse;

public interface CarrinhoService {

    CarrinhoResponse criaCarrinho(CarrinhoRequest carrinhoRequest);
}
