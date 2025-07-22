package br.com.siteware.virtualshop.carrinho.domain;

import br.com.siteware.virtualshop.carrinho.application.api.ItemCarrinhoRequest;
import br.com.siteware.virtualshop.produtos.domain.PromocaoTipo;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
    private boolean promocaoAtiva;


    public ItemCarrinho(ItemCarrinho itemRequest) {
        this.idProduto = itemRequest.getIdProduto();
        this.promocao = itemRequest.getPromocao();
        this.quantidade = itemRequest.getQuantidade();
    }

    public ItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest) {
        this.idProduto = itemCarrinhoRequest.getIdProduto();
        this.promocao = promocao != null ? promocao : PromocaoTipo.NENHUMA; /*depois tem q criar um metodo */
        this.quantidade = itemCarrinhoRequest.getQuantidade();
        this.promocaoAtiva = itemCarrinhoRequest.isPromocaoAtiva();
    }

    public void somarQuantidade(Integer quantidadeAdicional) {
        this.quantidade += quantidadeAdicional ;
    }
}


