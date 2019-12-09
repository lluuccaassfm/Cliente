package com.cliente.web.rest;

import com.cliente.domain.Endereco;
import com.cliente.service.EnderecoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

    private final Logger log = LoggerFactory.getLogger(EnderecoResource.class);

    private final EnderecoService enderecoService;

    public EnderecoResource(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> getAllEnderecos(){
        log.info("Get all enderecos");
        return enderecoService.getAllEndereco();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Endereco> GetById(@PathVariable(value = "id") Long id) {
        log.info("Get one endereco");
        Optional<Endereco> endereco = enderecoService.getOneEndereco(id);
        if(endereco.isPresent())
            return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public Endereco Post(@Valid @RequestBody Endereco endereco) {
        log.info("Create a endereco");

        return enderecoService.createEndereco(endereco);
    }

    @DeleteMapping()
    public String deleteEndereco(@RequestBody Endereco endereco){
        log.info("Delete a endereco ");
        return enderecoService.deleteEndereco(endereco);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

        log.info("Delete a endereco ");

        Optional<Endereco> endereco = enderecoService.getOneEndereco(id);
        if(endereco.isPresent()){
            enderecoService.deleteEndereco(endereco.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
