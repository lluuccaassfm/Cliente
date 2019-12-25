package com.cliente.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Perfil")
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PERFIL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "DS_PERFIL")
    private String descricao;
}
