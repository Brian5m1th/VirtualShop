package br.com.siteware.virtualshop.carrinho.infra;

import br.com.siteware.virtualshop.carrinho.domain.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarrinhoSpringJPARepository extends JpaRepository<Carrinho, UUID> {

}
