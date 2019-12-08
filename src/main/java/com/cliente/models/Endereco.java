package com.cliente.models;

import lombok.Data;

@Data
public class Endereco extends Identidade{

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;

}
