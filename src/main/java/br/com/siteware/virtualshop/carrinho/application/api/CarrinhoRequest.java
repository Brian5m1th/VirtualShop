package br.com.siteware.virtualshop.carrinho.application.api;

import br.com.siteware.virtualshop.carrinho.domain.ItemCarrinho;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarrinhoRequest {
    List<ItemCarrinho> itens;
}
