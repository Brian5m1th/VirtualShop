package br.com.siteware.virtualshop.carrinho.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/carrinho-de-compras")
public interface CarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse postCriaCarrinho(@RequestBody @Valid CarrinhoRequest carrinhoRequest);

    @PostMapping("/{idCarrinho}/itens")
    @ResponseStatus(code = HttpStatus.CREATED)
    ItemCarrinhoResponse postAdicionaItemCarrinho(@PathVariable UUID idCarrinho, @RequestBody @Valid ItemCarrinhoRequest itemCarrinhoRequest);

    @GetMapping("/{idCarrinho}")
    @ResponseStatus(code = HttpStatus.OK)
    CarrinhoDetalhadoResponse getBuscaCarrinho(@PathVariable UUID idCarrinho);

}