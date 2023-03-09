package com.example.jwtsecurity.domain.microservice.endereco;

import com.example.jwtsecurity.domain.eventos.Evento;
import com.example.jwtsecurity.domain.microservice.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotBlank
    private String logradouro;
    private String complemento;
    @NotBlank
    private String bairro;
    @Column(name = "cidade")
    @NotBlank
    private String localidade;
    @Column(name = "estado")
    @NotBlank
    private String uf;
    @NotBlank
    private String cep;


    @OneToOne(cascade = CascadeType.ALL)
    private Evento evento;
    @OneToOne(cascade = CascadeType.ALL)
    private Perfil perfil;
}
