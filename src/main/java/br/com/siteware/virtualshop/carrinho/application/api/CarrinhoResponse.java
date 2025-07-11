package br.com.siteware.virtualshop.carrinho.application.api;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CarrinhoResponse {
    private UUID idCarrinho;

    public CarrinhoResponse(UUID idCarrinho) {
        this.idCarrinho = idCarrinho;
    }
}
