package com.example.jwtsecurity.domain.microservice.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario u) {
        Usuario obj = userService.create(u);
        return obj != null ? ResponseEntity.ok(obj) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = userService.findAll();
        return list.size() > 0 ? ResponseEntity.ok().body(list) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Usuario> findById(@Valid @PathVariable Integer id){
        Usuario obj = userService.findMe(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    @GetMapping("/find/name/{username}")
    public ResponseEntity<Usuario> findByName(@Valid @PathVariable String username){
        Usuario obj = userService.findMeName(username);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @Valid @RequestBody Usuario usuario){
        Usuario novObj = userService.updateMe(id, usuario);
        return novObj != null ? ResponseEntity.ok().body(novObj) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Integer id){
        Usuario obj = userService.deleteMe(id);
        return obj != null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}