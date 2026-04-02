package br.ceub.ProjetoLivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ceub.ProjetoLivraria.domain.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}