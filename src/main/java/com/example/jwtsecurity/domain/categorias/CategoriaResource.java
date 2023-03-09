package com.example.jwtsecurity.domain.categorias;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

    private CategoriaService service;

    public CategoriaResource(CategoriaService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria c){
        Categoria obj = service.create(c);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = service.findAll();
        return list.size() > 0 ? ResponseEntity.ok().body(list) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria obj = service.findById(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @Valid @RequestBody Categoria c){
        Categoria novObj = service.update(id, c);
        return novObj != null ? ResponseEntity.ok().body(novObj) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return service.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
