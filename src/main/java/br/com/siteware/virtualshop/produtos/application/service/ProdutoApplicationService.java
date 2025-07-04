package br.com.siteware.virtualshop.produtos.application.service;

import br.com.siteware.virtualshop.produtos.application.api.ProdutoIdResponse;
import br.com.siteware.virtualshop.produtos.application.api.ProdutoRequest;
import br.com.siteware.virtualshop.produtos.application.repository.ProdutoRepository;
import br.com.siteware.virtualshop.produtos.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoIdResponse salvaProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - salvaProduto");
        Integer numeroDeProdutos = produtoRepository.countProdutosPeloIdProdutos(produtoRequest.getIdProduto());
        Produto novoProduto = new Produto(produtoRequest, numeroDeProdutos);
        produtoRepository.salva(novoProduto);
        log.info("[finish] ProdutoApplicationService - salvaProduto");
        return ProdutoIdResponse.builder().idProduto(novoProduto.getIdProduto()).build();
    }
}
