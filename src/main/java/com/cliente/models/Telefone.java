package com.cliente.models;

import lombok.Data;

@Data
public class Telefone extends Identidade{
    private String tipo;
    private Long numero;
    private Cliente cliente;
}
