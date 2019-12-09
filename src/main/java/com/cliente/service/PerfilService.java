package com.cliente.service;

import com.cliente.domain.Cliente;
import com.cliente.domain.Perfil;
import com.cliente.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> getAllPerfil(){

        return perfilRepository.findAll();
    }

    public Optional<Perfil> getOnePerfil(Long id){

        return perfilRepository.findById(id);
    }

    public Perfil createPerfil(Perfil perfil){

        return perfilRepository.save(perfil);
    }

    public String deletePerfil(Perfil perfil){
        perfilRepository.delete(perfil);
        return "Delete of sucess";
    }
}
