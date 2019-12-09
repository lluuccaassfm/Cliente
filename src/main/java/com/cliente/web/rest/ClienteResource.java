package com.cliente.web.rest;

import com.cliente.domain.Cliente;
import com.cliente.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "cliente")
public class ClienteResource {

    private final Logger log = LoggerFactory.getLogger(ClienteResource.class);

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes(){
        log.info("Get all clientes");
        return clienteService.getAllCliente();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Cliente> GetById(@PathVariable(value = "id") Long id) {
        log.info("Get one cliente");
        Optional <Cliente> cliente = clienteService.getOneCliente(id);
        if(cliente.isPresent())
            return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public Cliente Post(@Valid @RequestBody Cliente cliente) {
        log.info("Create a cliente");

        return clienteService.createCliente(cliente);
    }

    @DeleteMapping()
    public String deleteCliente(@RequestBody Cliente cliente){
        log.info("Delete a cliente ");
        return clienteService.deleteCliente(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

        log.info("Delete a cliente ");

        Optional<Cliente> cliente = clienteService.getOneCliente(id);
        if(cliente.isPresent()){
            clienteService.deleteCliente(cliente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
