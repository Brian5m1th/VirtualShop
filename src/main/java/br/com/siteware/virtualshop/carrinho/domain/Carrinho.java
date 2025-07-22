package br.com.siteware.virtualshop.carrinho.domain;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;
import br.com.siteware.virtualshop.carrinho.application.api.ItemCarrinhoRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCarrinho;
    @Embedded
    @ElementCollection
    @CollectionTable(name = "item_carrinho", joinColumns = @JoinColumn(name = "id_carrinho"))
    List<ItemCarrinho> itens;
    boolean promocaoAtiva;
    private BigDecimal subtotal;


    public Carrinho(CarrinhoRequest carrinhoRequest) {
        this.idCarrinho = UUID.randomUUID();
        this.itens = carrinhoRequest.getItens();
        this.promocaoAtiva = carrinhoRequest.isPromocaoAtiva();
    }

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

    public void adcionaOuSomaItem(ItemCarrinhoRequest itemCarrinhoRequest) {
        for (ItemCarrinho item : this.itens) {
            if (item.getIdProduto().equals(itemCarrinhoRequest.getIdProduto())) {
                item.somarQuantidade(itemCarrinhoRequest.getQuantidade());
                return;
            }
        }
        this.itens.add(new ItemCarrinho(itemCarrinhoRequest));
    }
}
