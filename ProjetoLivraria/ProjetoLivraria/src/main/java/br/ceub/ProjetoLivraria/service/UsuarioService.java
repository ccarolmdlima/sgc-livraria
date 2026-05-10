package br.ceub.ProjetoLivraria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ceub.ProjetoLivraria.domain.model.Usuario;
import br.ceub.ProjetoLivraria.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }
}