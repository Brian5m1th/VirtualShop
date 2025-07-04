package br.com.siteware.virtualshop.produtos.application.api;

import br.com.siteware.virtualshop.produtos.domain.PromocaoTipo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProdutoRequest {

    private UUID idProduto;
    @NotBlank(message = "Nome do produto é obrigatório")
    private String nome;
    private BigDecimal preco;
    private PromocaoTipo promocao;
}
