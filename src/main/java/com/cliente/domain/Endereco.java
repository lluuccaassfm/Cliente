package com.cliente.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private long id;

    @NotBlank
    @NotNull
    private String cep;

    @NotBlank
    @NotNull
    private String logradouro;

    @NotBlank
    @NotNull
    private String bairro;

    @NotBlank
    @NotNull
    private String cidade;

    @NotBlank
    @NotNull
    private String uf;

    private String complemento;
}
