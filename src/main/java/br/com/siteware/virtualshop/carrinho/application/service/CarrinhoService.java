package br.com.siteware.virtualshop.carrinho.application.service;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoResponse;
import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;

public interface CarrinhoService {

    CarrinhoResponse criaCarrinho(CarrinhoRequest carrinhoRequest);
}
