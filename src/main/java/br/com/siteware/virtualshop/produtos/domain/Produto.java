package br.com.siteware.virtualshop.produtos.domain;

import br.com.siteware.virtualshop.produtos.application.api.ProdutoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Produto {
    @Id
    private UUID idProduto;
    @NotBlank
    private String nome;
    private BigDecimal preco;
    private PromocaoTipo promocao;
    private Integer quantidadeDeProdutos;
    private UUID codigoProduto;

    public Produto(ProdutoRequest produtoRequest, Integer numeroDeProdutos) {
        this.idProduto = UUID.randomUUID();
        this.nome = produtoRequest.getNome();
        this.preco = produtoRequest.getPreco();
        this.promocao = produtoRequest.getPromocao() != null ? produtoRequest.getPromocao() : PromocaoTipo.NENHUMA;
        this.codigoProduto = produtoRequest.getCodigoProduto();
        this.quantidadeDeProdutos = (numeroDeProdutos != null ? numeroDeProdutos : 0) + 1;
    }

}
