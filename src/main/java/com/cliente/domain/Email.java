package com.cliente.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Email")
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @NotBlank
    private  String descricao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;
}
