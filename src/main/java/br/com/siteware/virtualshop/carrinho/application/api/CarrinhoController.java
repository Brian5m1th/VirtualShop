package br.com.siteware.virtualshop.carrinho.application.api;


import br.com.siteware.virtualshop.carrinho.application.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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


}
