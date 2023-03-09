package com.example.jwtsecurity.domain.microservice.usuarios;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "http://localhost:3000", name = "ms-usuario")
public interface UserService {

    @RequestMapping(method = RequestMethod.POST, value = "/user", consumes = "application/json")
    Usuario create(@RequestBody Usuario usuario);

    @RequestMapping(method = RequestMethod.GET, value = "/user", consumes = "application/json")
    List<Usuario> findAll();

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}", consumes = "application/json")
    Usuario findMe(@PathVariable("id") Integer id);

    @RequestMapping(method = RequestMethod.GET, value = "/user/name/{username}", consumes = "application/json")
    Usuario findMeName(@PathVariable("username") String username);

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}", consumes = "application/json")
    Usuario updateMe(@PathVariable("id") Integer id, @RequestBody Usuario usuario);

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}", consumes = "application/json")
    Usuario deleteMe(@PathVariable("id") Integer id);


}
