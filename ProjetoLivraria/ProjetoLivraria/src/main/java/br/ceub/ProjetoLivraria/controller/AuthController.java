package br.ceub.ProjetoLivraria.controller;

import br.ceub.ProjetoLivraria.config.JwtService;
import br.ceub.ProjetoLivraria.dto.AuthRequestDTO;
import br.ceub.ProjetoLivraria.dto.AuthResponseDTO;
import br.ceub.ProjetoLivraria.exception.BusinessException;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO dto) {

        if (dto.getUsername().equals("admin") && dto.getSenha().equals("123")) {
            String token = jwtService.gerarToken(dto.getUsername());
            return new AuthResponseDTO(token);
        }

        throw new BusinessException("Usuário ou senha inválidos.");
    }
}