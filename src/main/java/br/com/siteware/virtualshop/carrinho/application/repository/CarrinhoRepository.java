package br.com.siteware.virtualshop.carrinho.application.repository;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import br.com.siteware.virtualshop.produtos.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface CarrinhoRepository  {
    Carrinho salvaCarrinho(Carrinho carrinho);
}
