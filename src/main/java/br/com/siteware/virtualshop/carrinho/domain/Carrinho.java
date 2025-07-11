package br.com.siteware.virtualshop.carrinho.domain;

import br.com.siteware.virtualshop.carrinho.application.api.CarrinhoRequest;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table
public class Carrinho {
    @Id
    private UUID idCarrinho;
    @Embedded
    @ElementCollection
    @CollectionTable(name = "item_carrinho", joinColumns = @JoinColumn(name = "id_carrinho"))
    List<ItemCarrinho> itens;
    private BigDecimal ValorTotal;

    public Carrinho(CarrinhoRequest carrinhoRequest) {
        this.idCarrinho = UUID.randomUUID();
        this.itens = carrinhoRequest.getItens();
        this.ValorTotal = calcularValorTotal(carrinhoRequest.getItens());
    }

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = itens;
        this.ValorTotal = calcularValorTotal(itens);

    }

    private BigDecimal calcularValorTotal(List<ItemCarrinho> itens) {
        return itens.stream()
                .map(ItemCarrinho::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
