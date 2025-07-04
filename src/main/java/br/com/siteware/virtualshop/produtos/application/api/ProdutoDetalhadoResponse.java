package br.com.siteware.virtualshop.produtos.application.api;

import br.com.siteware.virtualshop.produtos.domain.Produto;
import br.com.siteware.virtualshop.produtos.domain.PromocaoTipo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProdutoDetalhadoResponse {
    private UUID idProduto;
    @NotBlank(message = "Nome do produto é obrigatório")
    private String nome;
    private BigDecimal preco;
    private PromocaoTipo promocao;
    private Integer quantidadeDeProdutos;

    public ProdutoDetalhadoResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.promocao = produto.getPromocao();
        this.quantidadeDeProdutos = produto.getQuantidadeDeProdutos();
    }

}
