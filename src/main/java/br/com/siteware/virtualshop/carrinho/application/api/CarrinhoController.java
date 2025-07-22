package br.com.siteware.virtualshop.carrinho.application.api;


import br.com.siteware.virtualshop.carrinho.application.service.CarrinhoService;
import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CarrinhoController implements CarrinhoAPI {
    private final CarrinhoService carrinhoService;

    @Override
    public CarrinhoResponse postCriaCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoController - postCriaCarrinho");
        CarrinhoResponse carrinho = carrinhoService.criaCarrinho(carrinhoRequest);
        log.info("[finish] CarrinhoController - postCriaCarrinho");
        return carrinho;
    }

    @Override
    public ItemCarrinhoResponse postAdicionaItemCarrinho(UUID idCarrinho, ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] CarrinhoController - postAdicionaItemCarrinho");
        ItemCarrinhoResponse itemCarrinhoResponse = carrinhoService.adicionaItemCarrinho(idCarrinho, itemCarrinhoRequest);
        log.info("[finish] CarrinhoController - postAdicionaItemCarrinho");
        return itemCarrinhoResponse;
    }

    @Override
    public CarrinhoDetalhadoResponse getBuscaCarrinho(UUID idCarrinho) {
        log.info("[start] CarrinhoController - getBuscaCarrinho");
        Carrinho carrinho = carrinhoService.buscaCarrinho(idCarrinho);
        log.info("[finish] CarrinhoController - getBuscaCarrinho");
        return new CarrinhoDetalhadoResponse(carrinho);
    }


}
