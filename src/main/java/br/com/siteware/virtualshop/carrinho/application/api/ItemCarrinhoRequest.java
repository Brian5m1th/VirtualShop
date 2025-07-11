package br.com.siteware.virtualshop.carrinho.application.api;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;
@Data
public class ItemCarrinhoRequest {

    @NotNull(message = "O id do produto é obrigatório")
    private UUID idProduto;

    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 1, message = "A quantidade deve ser no mínimo 1")
    private Integer quantidade;


}
