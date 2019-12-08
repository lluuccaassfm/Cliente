package com.cliente.models;

import lombok.Data;

@Data
public class Email extends Identidade{
    private String descricao;
    private Cliente cliente;
}
