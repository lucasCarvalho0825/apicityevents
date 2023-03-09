package com.example.jwtsecurity.domain.avaliacoes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class AvaliacaoResource {

    private AvaliacaoService service;

    public AvaliacaoResource(AvaliacaoService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Avaliacao> create(@Valid @RequestBody Avaliacao a){
        Avaliacao obj = service.create(a);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Avaliacao>> findAll(){
        List<Avaliacao> list = service.findAll();
        return list.size() > 0 ? ResponseEntity.ok().body(list) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Avaliacao> findById( @PathVariable Integer id){
        Avaliacao obj = service.findById(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable Integer id, @Valid @RequestBody Avaliacao a){
        Avaliacao novObj = service.update(id, a);
        return novObj != null ? ResponseEntity.ok().body(novObj) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return service.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
