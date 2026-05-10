package br.ceub.ProjetoLivraria.dto;

public class AuthRequestDTO {

    private String username;
    private String senha;

    public AuthRequestDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}