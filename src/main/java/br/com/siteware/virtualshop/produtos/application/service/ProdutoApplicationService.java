package br.com.siteware.virtualshop.produtos.application.service;

import br.com.siteware.virtualshop.produtos.application.api.ProdutoAlteracaoRequest;
import br.com.siteware.virtualshop.produtos.application.api.ProdutoIdResponse;
import br.com.siteware.virtualshop.produtos.application.api.ProdutoListResponse;
import br.com.siteware.virtualshop.produtos.application.api.ProdutoRequest;
import br.com.siteware.virtualshop.produtos.application.repository.ProdutoRepository;
import br.com.siteware.virtualshop.produtos.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoIdResponse salvaProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - salvaProduto");
        Integer numeroDeProdutos = produtoRepository.countProdutosPeloCodigo(produtoRequest.getCodigoProduto());
        Produto novoProduto = new Produto(produtoRequest, numeroDeProdutos);
        produtoRepository.salva(novoProduto);
        log.info("[finish] ProdutoApplicationService - salvaProduto");
        return ProdutoIdResponse.builder().idProduto(novoProduto.getIdProduto()).build();
    }

    @Override
    public Produto buscaProduto(UUID idProduto) {
        log.info("[start] ProdutoApplicationService - listaProdutos");
        Produto produto = produtoRepository.buscaProduto(idProduto);
        log.info("[finish] ProdutoApplicationService - listaProdutos");
        return produto;
    }

    @Override
    public List<ProdutoListResponse> listaTodosProdutos() {
        log.info("[start] ProdutoApplicationService - listaTodosProdutos");
        List<Produto> produto = produtoRepository.findByAllProdutos();
        log.info("[finish] ProdutoApplicationService - listaTodosProdutos");
        return ProdutoListResponse.converte(produto);
    }

    @Override
    public void alteraProduto(UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest) {
        log.info("[start] ProdutoApplicationService - alteraProduto");
        Produto produto = produtoRepository.buscaProduto(idProduto);
        produtoRepository.editaProduto(produto);
        log.info("[finish] ProdutoApplicationService - alteraProduto");
    }

    @Override
    public void deletaProduto(UUID idProduto) {
        log.info("[start] ProdutoApplicationService - deletaProduto");
        produtoRepository.deleteById(idProduto);
        log.info("[finish] ProdutoApplicationService - deletaProduto");
    }

    @Override
    public void limparTodosProdutos() {
        log.info("[start] ProdutoApplicationService - limparTodosProdutos");
        produtoRepository.deleteAll();
        log.info("[finish] ProdutoApplicationService - limparTodosProdutos");
    }
}
