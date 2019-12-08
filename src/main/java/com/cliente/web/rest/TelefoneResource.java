package com.cliente.web.rest;

import com.cliente.domain.Telefone;
import com.cliente.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("telefone")
public class TelefoneResource {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody
    Iterable<Telefone> getAllTelefones(){
        return telefoneRepository.findAll();
    }

    @PostMapping()
    public Telefone createTelefone(@RequestBody @Valid Telefone telefone){
        return telefoneRepository.save(telefone);
    }

    @DeleteMapping()
    public Telefone deleteTelefone(@RequestBody Telefone telefone){
        telefoneRepository.delete(telefone);
        return telefone;
    }
}
