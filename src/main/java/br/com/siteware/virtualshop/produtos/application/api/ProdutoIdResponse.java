package br.com.siteware.virtualshop.produtos.application.api;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProdutoIdResponse {
    private UUID idProduto;
}
