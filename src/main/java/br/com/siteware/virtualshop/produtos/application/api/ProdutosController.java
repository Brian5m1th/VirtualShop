package br.com.siteware.virtualshop.produtos.application.api;

import br.com.siteware.virtualshop.produtos.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
