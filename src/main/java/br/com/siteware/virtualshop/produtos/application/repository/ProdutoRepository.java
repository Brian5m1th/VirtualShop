package br.com.siteware.virtualshop.produtos.application.repository;

import br.com.siteware.virtualshop.produtos.application.api.ProdutoIdResponse;
import br.com.siteware.virtualshop.produtos.application.api.ProdutoRequest;
import br.com.siteware.virtualshop.produtos.domain.Produto;

import java.util.UUID;

public interface ProdutoRepository {
    Integer countProdutosPeloIdProdutos(UUID idProduto);
    void salva(Produto novoProduto);
    Produto listaProdutoPeloId(UUID idProduto);
}
