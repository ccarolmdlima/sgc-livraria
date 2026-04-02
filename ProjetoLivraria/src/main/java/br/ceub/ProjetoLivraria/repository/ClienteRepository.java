package br.ceub.ProjetoLivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ceub.ProjetoLivraria.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}