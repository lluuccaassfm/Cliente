package com.cliente.service;

import com.cliente.domain.Cliente;
import com.cliente.domain.Telefone;
import com.cliente.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public List<Telefone> getAllTelefone(){

        return telefoneRepository.findAll();
    }

    public Optional<Telefone> getOneTelefone(Long id){

        return telefoneRepository.findById(id);
    }

    public Telefone createTelefone(Telefone telefone){

        return telefoneRepository.save(telefone);
    }

    public String deleteTelefone(Telefone telefone){
        telefoneRepository.delete(telefone);
        return "Delete of sucess";
    }

}
