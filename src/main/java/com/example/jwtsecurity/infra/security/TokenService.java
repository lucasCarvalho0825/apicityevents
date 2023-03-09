package com.example.jwtsecurity.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.jwtsecurity.domain.microservice.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("{api.security.token.word-secret}")
    private String WORD_SECRET;
    public String gerarToken(Usuario usuario){
        try {
            var algorithm = Algorithm.HMAC256(WORD_SECRET);
            return JWT.create()
                    .withIssuer("api")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("ERRO AO GERAR TOKEN JWT ",exception);
        }
    }


    public String getSubject(String tokenJWT){
        try{
            var algorithm= Algorithm.HMAC256(WORD_SECRET);
            return JWT.require(algorithm)
                    .withIssuer("api")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }catch (JWTCreationException exception){
            throw new RuntimeException("ERRO  TOKEN JWT INVALIDO OU EXPIRADO ",exception);
        }
    }


    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
