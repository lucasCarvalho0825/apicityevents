package com.example.jwtsecurity.domain.microservice.endereco;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil/endereco")
public class CepResource {

    private CepService cepService;

    public CepResource(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
        Endereco endereco = cepService.buscaEnderecoPorCep(cep);
        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }
}
