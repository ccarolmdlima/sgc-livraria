package br.ceub.ProjetoLivraria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.ceub.ProjetoLivraria.domain.model.Usuario;
import br.ceub.ProjetoLivraria.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }
}