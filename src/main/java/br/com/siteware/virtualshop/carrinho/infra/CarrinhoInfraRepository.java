package br.com.siteware.virtualshop.carrinho.infra;

import br.com.siteware.virtualshop.carrinho.application.repository.CarrinhoRepository;
import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;


@Repository
@Log4j2
@RequiredArgsConstructor
public class CarrinhoInfraRepository implements CarrinhoRepository {
    private final CarrinhoSpringJPARepository carrinhoSpringJPARepository;

    @Override
    public Carrinho salvaCarrinho(Carrinho carrinho) {
        log.info("[start] CarrinhoInfraRepository - salvaCarrinho");
        Carrinho carrinhoSalvo = carrinhoSpringJPARepository.save(carrinho);
        log.info("[finish] CarrinhoInfraRepository - salvaCarrinho");
        return carrinhoSalvo;
    }
}
