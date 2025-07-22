package br.com.siteware.virtualshop.produtos.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/produtos")
public interface ProdutosAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoIdResponse postSalvaProduto(@RequestBody @Valid ProdutoRequest produtoRequest);

    @GetMapping("/{idProduto}")
    @ResponseStatus(code = HttpStatus.OK)
    ProdutoDetalhadoResponse getBuscaProduto(@PathVariable UUID idProduto);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoListResponse> getListaTodosProdutos();

    @PatchMapping("/{idProduto}/edita")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraProduto(@PathVariable UUID idProduto, @RequestBody @Valid ProdutoAlteracaoRequest produtoAlteracaoRequest);

    @DeleteMapping("/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaProduto(@PathVariable UUID idProduto);

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaTodosProdutos();
}