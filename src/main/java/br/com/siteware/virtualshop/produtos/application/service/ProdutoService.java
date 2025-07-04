package br.com.siteware.virtualshop.produtos.application.service;

import br.com.siteware.virtualshop.produtos.application.api.ProdutoIdResponse;
import br.com.siteware.virtualshop.produtos.application.api.ProdutoRequest;

public interface ProdutoService {
    ProdutoIdResponse salvaProduto(ProdutoRequest produtoRequest);
}
