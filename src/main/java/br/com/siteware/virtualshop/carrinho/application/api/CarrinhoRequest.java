package br.com.siteware.virtualshop.carrinho.application.api;

import br.com.siteware.virtualshop.carrinho.domain.ItemCarrinho;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CarrinhoRequest {
    List<ItemCarrinho> itens;
    boolean promocaoAtiva;
}
