package com.example.jwtsecurity.domain.microservice.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:3000", name = "ms-auth")
public interface AuthClient {

    @RequestMapping(method = RequestMethod.POST, value = "/auth", consumes = "application/json")
    Token login(@RequestBody Credentials credentials);


}
