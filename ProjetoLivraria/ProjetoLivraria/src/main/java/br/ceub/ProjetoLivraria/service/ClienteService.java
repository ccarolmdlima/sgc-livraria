package br.ceub.ProjetoLivraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.ceub.ProjetoLivraria.domain.model.Cliente;
import br.ceub.ProjetoLivraria.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        return cliente.orElseThrow();
    }

    public Cliente atualizar(Long id, Cliente novoCliente) {

        Cliente cliente = buscarPorId(id);

        cliente.setNome(novoCliente.getNome());
        cliente.setCpf(novoCliente.getCpf());
        cliente.setEmail(novoCliente.getEmail());
        cliente.setTelefone(novoCliente.getTelefone());
        cliente.setEndereco(novoCliente.getEndereco());

        return repository.save(cliente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}