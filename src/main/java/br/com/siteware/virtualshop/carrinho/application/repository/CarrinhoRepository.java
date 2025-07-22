package br.com.siteware.virtualshop.carrinho.application.repository;

import br.com.siteware.virtualshop.carrinho.domain.Carrinho;

import java.util.UUID;

public interface CarrinhoRepository  {
    Carrinho salvaCarrinho(Carrinho carrinho);
    Carrinho buscaCarrinho(UUID idCarrinho);
}
