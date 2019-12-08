package com.cliente.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private long id;

    @NotBlank
    @NotNull
    @Column(name = "NOME_CLIENTE")
    private String nome;

    @NotBlank
    @NotNull
    @Column(name = "CPF_CLIENTE")
    private String cpf;

    @NotBlank
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_PERFIL")
    private Perfil perfil;

    @NotBlank
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;
}
