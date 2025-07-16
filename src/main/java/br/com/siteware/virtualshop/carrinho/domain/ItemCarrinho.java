package br.com.siteware.virtualshop.carrinho.domain;

import br.com.siteware.virtualshop.carrinho.application.api.ItemCarrinhoRequest;
import br.com.siteware.virtualshop.produtos.domain.PromocaoTipo;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ItemCarrinho {
    private UUID idProduto;
    private PromocaoTipo promocao;
    private Integer quantidade;
    private BigDecimal subtotal;

    public ItemCarrinho(ItemCarrinhoRequest itemRequest) {
        this.idProduto = itemRequest.getIdProduto();
        this.promocao = promocao != null ? promocao : PromocaoTipo.NENHUMA; /*depois tem q criar um metodo */
        this.quantidade = itemRequest.getQuantidade();
    }
}


