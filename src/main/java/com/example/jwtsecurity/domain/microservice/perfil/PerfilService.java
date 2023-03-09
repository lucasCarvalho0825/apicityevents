package com.example.jwtsecurity.domain.microservice.perfil;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:3000", name = "ms-perfil")
public interface PerfilService {

    @RequestMapping(method = RequestMethod.GET, value = "/perfil/{id}", consumes = "application/json")
    Perfil findMe(@PathVariable("id") Integer id);
    @RequestMapping(method = RequestMethod.PUT, value = "/perfil/{id}", consumes = "application/json")
    Perfil updateMe(@PathVariable("id") Integer id, @RequestBody Perfil perfil);


}
