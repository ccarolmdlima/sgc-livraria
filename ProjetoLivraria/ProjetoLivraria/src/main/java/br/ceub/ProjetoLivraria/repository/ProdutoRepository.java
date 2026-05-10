package br.ceub.ProjetoLivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ceub.ProjetoLivraria.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}