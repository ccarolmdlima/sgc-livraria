package br.ceub.ProjetoLivraria.dto;

import java.util.List;

public class VendaDTO {

    private Long clienteId;
    private Long usuarioId;
    private List<ItemVendaDTO> itens;

    public VendaDTO() {
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }


    public List<ItemVendaDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaDTO> itens) {
        this.itens = itens;
    }
}