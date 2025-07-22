package br.com.siteware.virtualshop.carrinho.application.service;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoResponse;
import br.com.siteware.virtualshop.carrinho.application.api.ItemCarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.application.api.ItemCarrinhoResponse;
import br.com.siteware.virtualshop.carrinho.domain.Carrinho;

import java.util.UUID;

public interface CarrinhoService {

    CarrinhoResponse criaCarrinho(CarrinhoRequest carrinhoRequest);
    ItemCarrinhoResponse adicionaItemCarrinho(UUID idCarrinho, ItemCarrinhoRequest itemCarrinhoRequest);
    Carrinho buscaCarrinho(UUID idCarrinho);
}
