package br.com.siteware.virtualshop.produtos.infra;

import br.com.siteware.virtualshop.handler.APIException;
import br.com.siteware.virtualshop.produtos.application.repository.ProdutoRepository;
import br.com.siteware.virtualshop.produtos.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ProdutoInfraRepository implements ProdutoRepository {
    private final ProdutoSpringJPARepository produtoSpringJPARepository;

    @Override
    public Integer countProdutosPeloCodigo(UUID codigoProduto) {
        log.info("[start] ProdutoInfraRepository - countProdutosPeloIdProdutos");
        Integer numerosDeProdutos =  produtoSpringJPARepository.countByCodigoProduto(codigoProduto);
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

    @Override
    public Produto buscaProduto(UUID idProduto) {
        log.info("[start] ProdutoInfraRepository - listaProdutoPeloId");
        Produto produto = produtoSpringJPARepository.findByIdProduto(idProduto)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        log.info("[finish] ProdutoInfraRepository - listaProdutoPeloId");
        return produto;
    }

    @Override
    public List<Produto> findByAllProdutos() {
        log.info("[start] ProdutoInfraRepository - findByAllProdutos");
        List<Produto> produtos = produtoSpringJPARepository.findAll();
        log.info("[finish] ProdutoInfraRepository - findByAllProdutos");
        return produtos;
    }

    @Override
    public void editaProduto(Produto produto) {
        log.info("[start] ProdutoInfraRepository - editaProduto");
        produtoSpringJPARepository.save(produto);
        log.info("[finish] ProdutoInfraRepository - editaProduto");
    }

    @Override
    public void deleteById(UUID idProduto) {
        log.info("[start] ProdutoInfraRepository - deleteById");
        produtoSpringJPARepository.deleteById(idProduto);
        log.info("[finish] ProdutoInfraRepository - deleteById");
    }

    @Override
    public void deleteAll() {
        log.info("[start] ProdutoInfraRepository - deleteAll");
        produtoSpringJPARepository.deleteAll();
        log.info("[finish] ProdutoInfraRepository - deleteAll");
    }
}
