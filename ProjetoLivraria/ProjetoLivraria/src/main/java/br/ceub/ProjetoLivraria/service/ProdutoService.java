package br.ceub.ProjetoLivraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.ceub.ProjetoLivraria.domain.model.Produto;
import br.ceub.ProjetoLivraria.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto buscarPorId(Long id) {

        Optional<Produto> produto = repository.findById(id);

        return produto.orElseThrow();
    }

    public Produto atualizar(Long id, Produto novoProduto) {

        Produto produto = buscarPorId(id);

        produto.setNome(novoProduto.getNome());
        produto.setDescricao(novoProduto.getDescricao());
        produto.setPreco(novoProduto.getPreco());
        produto.setEstoque(novoProduto.getEstoque());

        return repository.save(produto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}