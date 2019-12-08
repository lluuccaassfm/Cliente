package com.cliente.web.rest;

import com.cliente.domain.Endereco;
import com.cliente.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody
    Iterable<Endereco> getAllEnderecos(){
        return enderecoRepository.findAll();
    }

    @PostMapping()
    public Endereco createEndereco(@RequestBody @Valid Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    @DeleteMapping()
    public Endereco deleteEndereco(@RequestBody Endereco endereco){
        enderecoRepository.delete(endereco);
        return endereco;
    }
}
