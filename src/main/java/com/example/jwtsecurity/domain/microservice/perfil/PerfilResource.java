package com.example.jwtsecurity.domain.microservice.perfil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {

    private PerfilService perfilService;

    public PerfilResource(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Perfil> findById(@PathVariable Integer id){
        Perfil obj = perfilService.findMe(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Perfil> update(@PathVariable Integer id, @Valid @RequestBody Perfil perfil){
        Perfil novObj = perfilService.updateMe(id, perfil);
        return novObj != null ? ResponseEntity.ok().body(novObj) : ResponseEntity.badRequest().build();
    }
}
