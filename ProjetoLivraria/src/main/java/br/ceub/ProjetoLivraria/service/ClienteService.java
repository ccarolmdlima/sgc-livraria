package br.ceub.ProjetoLivraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.ceub.ProjetoLivraria.domain.model.Cliente;
import br.ceub.ProjetoLivraria.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }
}