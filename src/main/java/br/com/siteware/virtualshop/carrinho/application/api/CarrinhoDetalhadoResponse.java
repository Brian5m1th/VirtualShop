package br.com.siteware.virtualshop.carrinho.application.api;

import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import br.com.siteware.virtualshop.carrinho.domain.ItemCarrinho;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class CarrinhoDetalhadoResponse {
    private UUID idCarrinho;
    private BigDecimal subtotal;
    private List<ItemCarrinho> itens;

    public CarrinhoDetalhadoResponse(Carrinho carrinho) {
        this.idCarrinho = carrinho.getIdCarrinho();
        this.subtotal = carrinho.getSubtotal();
        this.itens = carrinho.getItens();
    }
}