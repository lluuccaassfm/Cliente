package com.cliente.web.rest;

import com.cliente.domain.Cliente;
import com.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    @PostMapping()
    public Cliente createCliente(@RequestBody @Valid Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping()
    public Cliente deleteCliente(@RequestBody Cliente cliente){
        clienteRepository.delete(cliente);
        return cliente;
    }
}
