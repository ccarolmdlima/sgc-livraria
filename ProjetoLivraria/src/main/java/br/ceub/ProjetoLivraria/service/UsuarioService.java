package br.ceub.ProjetoLivraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.ceub.ProjetoLivraria.domain.model.Usuario;
import br.ceub.ProjetoLivraria.repository.UsuarioRepository;

public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar() {
        return repository.findAll();
    }
}