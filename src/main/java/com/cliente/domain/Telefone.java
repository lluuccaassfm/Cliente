package com.cliente.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TELEFONE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "NUMERO")
    private  String numero;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
}
