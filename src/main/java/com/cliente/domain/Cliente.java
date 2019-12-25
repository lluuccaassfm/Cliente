package com.cliente.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "Cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "NOME_CLIENTE")
    private String nome;

    @NotNull
    @Column(name = "CPF")
    private String cpf;

    @NotNull
    @Column(name = "SENHA")
    private String senha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_PERFIL", nullable = false)
    private Perfil perfil;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_ENDERECO", nullable = false)
    private Endereco endereco;
}
