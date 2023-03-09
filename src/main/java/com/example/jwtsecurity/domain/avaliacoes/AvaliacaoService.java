package com.example.jwtsecurity.domain.avaliacoes;

import com.example.jwtsecurity.infra.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    private AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }


    // APENAS USER DO TIPO USER PODEM AVALIAR OS EVENTOS
    public Avaliacao create(Avaliacao a){
        return repository.save(a);
    }

    // APENAS MODERADORES PODEM TER ACESSO A TODAS AS AVALIAÇÕES
    public List<Avaliacao> findAll(){
        return repository.findAll();
    }

    // APENAS USER DO TIPO USER PODEM BUSCAR POR UMA AVALIAÇÃO ( A SUA )
    public Avaliacao findById(Integer id){
        Optional<Avaliacao> r = repository.findById(id);
        return r.orElseThrow(() -> new ObjectNotFoundException("Not Found Category"));
    }

    // APENAS USER DO TIPO USER PODEM ATUALIZAR UMA AVALIAÇÃO ( A SUA )
    public Avaliacao update (Integer id, @Valid Avaliacao a) {
        Avaliacao oldA = findById(id);
        oldA.setValue(a.getValue());
        return repository.saveAndFlush(oldA);
    }

    // APENAS USER DO TIPO USER PODEM DELETAR UMA AVALIAÇÃO ( A SUA )
    public boolean delete(Integer id) {
        Avaliacao r = findById(id);
        if(r != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
