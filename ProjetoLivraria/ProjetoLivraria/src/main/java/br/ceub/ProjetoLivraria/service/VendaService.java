package br.ceub.ProjetoLivraria.service;

import br.ceub.ProjetoLivraria.domain.model.ItemVenda;
import br.ceub.ProjetoLivraria.domain.model.Venda;
import br.ceub.ProjetoLivraria.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    private final VendaRepository repository;

    public VendaService(VendaRepository repository) {
        this.repository = repository;
    }

    public List<Venda> listar() {
        return repository.findAll();
    }

    public Venda salvar(Venda venda) {

        double total = 0;

        for(ItemVenda item : venda.getItens()) {

            total += item.getPrecoUnitario()
                    * item.getQuantidade();
        }

        venda.setValorTotal(total);

        return repository.save(venda);
    }

    public Venda buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }
}