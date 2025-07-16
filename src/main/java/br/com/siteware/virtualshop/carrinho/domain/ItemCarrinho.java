package br.com.siteware.virtualshop.carrinho.domain;

import br.com.siteware.virtualshop.produtos.domain.PromocaoTipo;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ItemCarrinho {
    private UUID idProduto;
    private PromocaoTipo promocao;
    private Integer quantidade;

    public ItemCarrinho(ItemCarrinho itemRequest) {
        this.idProduto = itemRequest.getIdProduto();
        this.promocao = promocao != null ? promocao : PromocaoTipo.NENHUMA; /*depois tem q criar um metodo */
        this.quantidade = itemRequest.getQuantidade();
    }

}


