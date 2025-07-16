package br.com.siteware.virtualshop.carrinho.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/carrinho-de-compras")
public interface CarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse postCriaCarrinho(@RequestBody @Valid CarrinhoRequest carrinhoRequest);

}