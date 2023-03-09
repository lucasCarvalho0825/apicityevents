package com.example.jwtsecurity.domain.microservice.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private AuthClient service;

    public AuthController(AuthClient service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Token> create(@Valid @RequestBody Credentials c) {
        Token obj = service.login(c);
        return obj != null ? ResponseEntity.ok(obj) : ResponseEntity.badRequest().build();
    }
}
