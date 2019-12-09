package com.cliente.web.rest;

import com.cliente.domain.Telefone;
import com.cliente.service.TelefoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("telefone")
public class TelefoneResource {

    private final Logger log = LoggerFactory.getLogger(TelefoneResource.class);

    private final TelefoneService telefoneService;

    public TelefoneResource(TelefoneService telefoneService) {
        this.telefoneService = telefoneService;
    }

    @GetMapping
    public List<Telefone> getAllTelefones(){
        log.info("Get all telefones");
        return telefoneService.getAllTelefone();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Telefone> GetById(@PathVariable(value = "id") Long id) {
        log.info("Get one telefone");
        Optional<Telefone> telefone = telefoneService.getOneTelefone(id);
        if(telefone.isPresent())
            return new ResponseEntity<Telefone>(telefone.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public Telefone Post(@Valid @RequestBody Telefone telefone) {
        log.info("Create a telefone");

        return telefoneService.createTelefone(telefone);
    }

    @DeleteMapping()
    public String deleteTelefone(@RequestBody Telefone telefone){
        log.info("Delete a telefone ");
        return telefoneService.deleteTelefone(telefone);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

        log.info("Delete a telefone ");

        Optional<Telefone> telefone = telefoneService.getOneTelefone(id);
        if(telefone.isPresent()){
            telefoneService.deleteTelefone(telefone.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
