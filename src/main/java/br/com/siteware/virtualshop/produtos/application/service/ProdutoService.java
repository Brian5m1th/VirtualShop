package br.com.siteware.virtualshop.produtos.application.service;

import br.com.siteware.virtualshop.produtos.application.api.ProdutoIdResponse;
import br.com.siteware.virtualshop.produtos.application.api.ProdutoRequest;
import br.com.siteware.virtualshop.produtos.domain.Produto;

import java.util.UUID;

public interface ProdutoService {
    ProdutoIdResponse salvaProduto(ProdutoRequest produtoRequest);
    Produto listaProdutos(UUID idProduto);
}
