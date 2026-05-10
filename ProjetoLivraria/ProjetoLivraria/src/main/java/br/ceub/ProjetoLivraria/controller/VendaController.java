package br.ceub.ProjetoLivraria.controller;

import br.ceub.ProjetoLivraria.domain.model.Venda;
import br.ceub.ProjetoLivraria.service.VendaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping
    public Venda salvar(@RequestBody Venda venda) {
        return service.salvar(venda);
    }

    @GetMapping("/{id}")
    public Venda buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}