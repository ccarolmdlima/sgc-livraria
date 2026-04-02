package br.ceub.ProjetoLivraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.ceub.ProjetoLivraria.domain.model.Venda;
import br.ceub.ProjetoLivraria.repository.VendaRepository;

public class VendaService {

    @Autowired
    private VendaRepository repository;

    public List<Venda> listar() {
        return repository.findAll();
    }
}