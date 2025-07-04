package br.com.siteware.virtualshop.produtos.application.api;

import br.com.siteware.virtualshop.produtos.application.service.ProdutoService;
import br.com.siteware.virtualshop.produtos.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ProdutosController implements ProdutosAPI {
    private final ProdutoService produtoService;

    @Override
    public ProdutoIdResponse postSalvaProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutosController - postSalvaProduto");
        ProdutoIdResponse produto = produtoService.salvaProduto(produtoRequest);
        log.info("[finish] ProdutosController - postSalvaProduto");
        return produto ;
    }

    @Override
    public ProdutoDetalhadoResponse getListaProdutos(UUID idProduto) {
        log.info("[start] ProdutosController - getListaProdutos");
        Produto produto = produtoService.listaProdutos(idProduto);
        log.info("[finish] ProdutosController - getListaProdutos");
        return new ProdutoDetalhadoResponse(produto);
    }

    @Override
    public List<ProdutoListResponse> getListaTodosProdutos() {
        log.info("[start] ProdutosController - getListaTodosProdutos");
        List<ProdutoListResponse> produtos = produtoService.listaTodosProdutos();
        log.info("[finish] ProdutosController - getListaTodosProdutos");
        return produtos;
    }

    @Override
    public void patchAlteraProduto(UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest) {
        log.info("[start] ProdutosController - alteraProduto");
        log.info("Alterando produto com ID: {}", idProduto);
        produtoService.alteraProduto(idProduto, produtoAlteracaoRequest);
        log.info("[finish] ProdutosController - alteraProduto");
    }
}
