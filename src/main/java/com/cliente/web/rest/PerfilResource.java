package com.cliente.web.rest;

import com.cliente.domain.Perfil;
import com.cliente.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {
    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody
    Iterable<Perfil> getAllPerfils(){
        return perfilRepository.findAll();
    }

    @PostMapping()
    public Perfil createPerfil(@RequestBody @Valid Perfil perfil){
        return perfilRepository.save(perfil);
    }

    @DeleteMapping()
    public Perfil deletePerfil(@RequestBody Perfil perfil){
        perfilRepository.delete(perfil);
        return perfil;
    }
}
