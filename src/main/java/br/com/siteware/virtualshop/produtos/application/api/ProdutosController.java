package br.com.siteware.virtualshop.produtos.application.api;

import br.com.siteware.virtualshop.produtos.application.service.ProdutoService;
import br.com.siteware.virtualshop.produtos.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
