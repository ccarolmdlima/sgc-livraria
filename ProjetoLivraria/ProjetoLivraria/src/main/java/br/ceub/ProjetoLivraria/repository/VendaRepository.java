package br.ceub.ProjetoLivraria.repository;

import br.ceub.ProjetoLivraria.domain.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}