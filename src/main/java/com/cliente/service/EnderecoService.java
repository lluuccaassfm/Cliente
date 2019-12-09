package com.cliente.service;

import com.cliente.domain.Cliente;
import com.cliente.domain.Endereco;
import com.cliente.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> getAllEndereco(){

        return enderecoRepository.findAll();
    }

    public Optional<Endereco> getOneEndereco(Long id){

        return enderecoRepository.findById(id);
    }

    public Endereco createEndereco(Endereco endereco){

        return enderecoRepository.save(endereco);
    }

    public String deleteEndereco(Endereco endereco){
        enderecoRepository.delete(endereco);
        return "Delete of sucess";
    }

}
