package com.example.jwtsecurity.domain.eventos;

import com.example.jwtsecurity.domain.microservice.endereco.EnderecoRepository;
import com.example.jwtsecurity.infra.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private EventoRepository repository;
    private EnderecoRepository enderecoRepository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    public Evento create(@Valid Evento e){
        //addressRepository.save(e.getAddress());
        return repository.save(e);
    }


    public List<Evento> findAll(){

        List<Evento> list = repository.findAll();
        /*
        *  realizar as validação
        *  SE a data for MENOR que a DATA ATUAL deixar fora da lista
        *
        *  via QUARY ou validação JAVA
        * */
        return list;
    }

    public Evento findById(Long id){
        Optional<Evento> e = repository.findById(id);
        return e.orElseThrow(
                () -> new ObjectNotFoundException("Nenhuma resultado encontrado para o Id: "+ id));
    }

    public Evento update (Long id, @Valid Evento e) {
        Evento old = findById(id);

        old.setTitle(e.getTitle());
        old.setStartDate(e.getStartDate());
        old.setEndDate(e.getEndDate());
        old.setStatus(old.isStatus());
        old.setDiscription(e.getDiscription());
        old.setCategorias(e.getCategorias());
        old.setEndereco(e.getEndereco());

        enderecoRepository.saveAndFlush(e.getEndereco());

        return repository.saveAndFlush(old);
    }

    public boolean delete(Long id) {
        Evento e = findById(id);
        if(e != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
