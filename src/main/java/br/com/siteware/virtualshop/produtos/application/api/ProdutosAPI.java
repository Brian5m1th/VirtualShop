package br.com.siteware.virtualshop.produtos.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/produtos")
public interface ProdutosAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoIdResponse postSalvaProduto(@RequestBody @Valid ProdutoRequest produtoRequest);

    @GetMapping("/{idProduto}")
    @ResponseStatus(code = HttpStatus.OK)
    ProdutoDetalhadoResponse getListaProdutos(@PathVariable UUID idProduto);

}