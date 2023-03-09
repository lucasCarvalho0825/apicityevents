package com.example.jwtsecurity.domain.auth;

import com.example.jwtsecurity.domain.microservice.auth.Credentials;
import com.example.jwtsecurity.domain.microservice.auth.Token;
import com.example.jwtsecurity.domain.microservice.usuarios.Usuario;
import com.example.jwtsecurity.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthResource {

    private AuthService service;

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    public AuthResource(AuthService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid Credentials credentials){
        var token = new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password());
        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok().body(new Token(tokenJWT));
    }
}
