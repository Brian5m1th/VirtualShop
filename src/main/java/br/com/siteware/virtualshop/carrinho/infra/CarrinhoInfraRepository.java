package br.com.siteware.virtualshop.carrinho.infra;

import br.com.siteware.virtualshop.carrinho.application.repository.CarrinhoRepository;
import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;


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

    @Override
    public Carrinho buscaCarrinho(UUID idCarrinho) {
        log.info("[start] CarrinhoInfraRepository - buscaCarrinho");
        Carrinho carrinho = carrinhoSpringJPARepository.findById(idCarrinho)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado com o ID: " + idCarrinho));
        log.info("[finish] CarrinhoInfraRepository - buscaCarrinho");
        return carrinho;
    }
}
