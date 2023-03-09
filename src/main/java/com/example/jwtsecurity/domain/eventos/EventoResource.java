package com.example.jwtsecurity.domain.eventos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoResource {

   /* TESTES DAS FUNCIONALIDADES DOS MÉTODOS NÃO  REALIZADO, NÃO SEI SE ESSA CLASS PRESTA */


    private EventoService service;

    public EventoResource(EventoService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public ResponseEntity<Evento> create(@Valid @RequestBody Evento e){
        Evento obj = service.create(e);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Evento>> findAll(){
        List<Evento> list = service.findAll();
        return list.size() > 0 ? ResponseEntity.ok().body(list) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Evento> findById(@PathVariable Long id){
        Evento obj = service.findById(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Evento> update(@PathVariable Long id, @Valid @RequestBody Evento e){
        Evento novObj = service.update(id, e);
        return novObj != null ? ResponseEntity.ok().body(novObj) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return service.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

}
