package br.com.siteware.virtualshop.carrinho.application.api;

import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import br.com.siteware.virtualshop.carrinho.domain.ItemCarrinho;
import lombok.Data;

import java.util.List;

@Data
public class ItemCarrinhoResponse {
    List<ItemCarrinho> itens;

    public ItemCarrinhoResponse(Carrinho carrinho) {
        this.itens = carrinho.getItens();
    }

}
