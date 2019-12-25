package com.cliente.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "CEP")
    private String cep;

    @NotNull
    @Column(name = "LOGRADOURO")
    private String logradouro;

    @NotNull
    @Column(name = "BAIRRO")
    private String bairro;

    @NotNull
    @Column(name = "CIDADE")
    private String cidade;

    @NotNull
    @Column(name = "UF")
    private String uf;

    @Column(name = "COMPLEMENTO")
    private String complemento;
}
