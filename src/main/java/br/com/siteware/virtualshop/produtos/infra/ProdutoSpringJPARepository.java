package br.com.siteware.virtualshop.produtos.infra;

import br.com.siteware.virtualshop.produtos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoSpringJPARepository extends JpaRepository<Produto, UUID> {
    Integer countByCodigoProduto(UUID codigoProduto);
    Optional<Produto> findByIdProduto(UUID idProduto);
}
