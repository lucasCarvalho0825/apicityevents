package com.example.jwtsecurity.domain.categorias;

import com.example.jwtsecurity.infra.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }


    public Categoria create(Categoria c){
        return repository.save(c);
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria findById(Integer id){
        Optional<Categoria> c = repository.findById(id);
        return c.orElseThrow(() -> new ObjectNotFoundException("Not Found Category"));
    }

    public Categoria update(Integer id, Categoria c) {
        Categoria oldC = findById(id);
        oldC.setTitulo(c.getTitulo());
        return repository.saveAndFlush(oldC);
    }

    public boolean delete(Integer id) {
        Categoria c = findById(id);
        if(c != null) {
           repository.deleteById(id);
           return true;
        }
        return false;
    }
}
