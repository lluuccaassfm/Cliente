package com.cliente.models;

import lombok.Data;

@Data
public class Cliente extends Identidade{

    private String nome;
    private String cpf;
    private Endereco endereco;

}
