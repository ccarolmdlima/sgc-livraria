package br.ceub.ProjetoLivraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ceub.ProjetoLivraria.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}