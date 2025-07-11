package br.com.siteware.virtualshop.produtos.application.repository;

import br.com.siteware.virtualshop.produtos.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository {
    Integer countProdutosPeloCodigo(UUID codigoProduto);
    void salva(Produto novoProduto);
    Produto buscaProdutos(UUID idProduto);
    List<Produto> findByAllProdutos();
    void editaProduto(Produto produto);
    void deleteById(UUID idProduto);
    void deleteAll();
}
