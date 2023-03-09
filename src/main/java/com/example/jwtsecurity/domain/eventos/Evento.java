package com.example.jwtsecurity.domain.eventos;

import com.example.jwtsecurity.domain.avaliacoes.Avaliacao;
import com.example.jwtsecurity.domain.categorias.Categoria;
import com.example.jwtsecurity.domain.microservice.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "eventos")
public class Evento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotBlank
    private String title;
    @NotBlank
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime startDate;
    @NotBlank
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime endDate;
    private String discription;
    private boolean paid;
    @Max(100)
    @Min(1)
    private Integer ageMin;
    @NotNull
    private boolean status;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Set<Avaliacao> avaliacoes;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Set<Categoria> categorias;
    @OneToOne(mappedBy = "evento", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
}
