CREATE TABLE IF NOT EXISTS  endereco(
    id_endereco BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL ,
    cep VARCHAR(8) NOT NULL ,
    logradouro VARCHAR(30) NOT NULL ,
    bairro VARCHAR(30) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    uf VARCHAR(20) NOT NULL,
    complemento VARCHAR(50)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS  perfil(
    id_perfil BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    ds_perfil VARCHAR(255)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS cliente(
    id_cliente BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome_cliente VARCHAR(50) NOT NULL ,
    cpf VARCHAR(11) NOT NULL ,
    senha VARCHAR(15) NOT NULL ,
    id_perfil  BIGINT(20),
    id_endereco  BIGINT(20),
    CONSTRAINT fk_cliente_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id_perfil),
    CONSTRAINT fk_cliente_endereco FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS telefone(
    id_telefone BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    numero VARCHAR(15),
    id_cliente  BIGINT(20),
    CONSTRAINT fk_telefone_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS email
(
    id_email BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    ds_email VARCHAR(15),
    id_cliente   BIGINT(20),
    CONSTRAINT fk_email_cliente FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
) DEFAULT CHAR SET=utf8

