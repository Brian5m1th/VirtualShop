package br.com.siteware.virtualshop.produtos.infra;

import br.com.siteware.virtualshop.handler.APIException;
import br.com.siteware.virtualshop.produtos.application.repository.ProdutoRepository;
import br.com.siteware.virtualshop.produtos.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ProdutoInfraRepository implements ProdutoRepository {
    private final ProdutoSpringJPARepository produtoSpringJPARepository;

    @Override
    public Integer countProdutosPeloIdProdutos(UUID idProduto) {
        log.info("[start] ProdutoInfraRepository - countProdutosPeloIdProdutos");
        Integer numerosDeProdutos =  produtoSpringJPARepository.countProdutosByIdProduto(idProduto);
        log.info("[finish] ProdutoInfraRepository - countProdutosPeloIdProdutos");
        return numerosDeProdutos;
    }

    @Override
    public void salva(Produto novoProduto) {
        try {
            produtoSpringJPARepository.save(novoProduto);
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Tarefa já cadastrada", e);
        }
    }
}
