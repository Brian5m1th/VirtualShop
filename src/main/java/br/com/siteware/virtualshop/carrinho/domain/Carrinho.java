package br.com.siteware.virtualshop.carrinho.domain;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Carrinho(CarrinhoRequest carrinhoRequest) {
        this.idCarrinho = UUID.randomUUID();
        this.itens = carrinhoRequest.getItens();
    }

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

}
