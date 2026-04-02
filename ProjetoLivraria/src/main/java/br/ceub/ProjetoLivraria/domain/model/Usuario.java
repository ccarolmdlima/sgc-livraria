package br.ceub.ProjetoLivraria.domain.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String senha;
    private String perfil; // Ex: "ADMIN", "VENDEDOR"
}