package br.ceub.ProjetoLivraria.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET =
            "segredo-super-seguro-segredo-super-seguro";

    private final Key key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public String gerarToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis()
                                + 86400000)
                )
                .signWith(key)
                .compact();
    }
}