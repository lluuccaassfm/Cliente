package com.cliente.web.rest;

import com.cliente.domain.Perfil;
import com.cliente.service.PerfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {

    private final Logger log = LoggerFactory.getLogger(PerfilResource.class);

    private final PerfilService perfilService;

    public PerfilResource(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping
    public List<Perfil> getAllPerfils(){
        log.info("Get all perfils");
        return perfilService.getAllPerfil();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Perfil> GetById(@PathVariable(value = "id") Long id) {
        log.info("Get one perfil");
        Optional<Perfil> perfil = perfilService.getOnePerfil(id);
        if(perfil.isPresent())
            return new ResponseEntity<Perfil>(perfil.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public Perfil Post(@Valid @RequestBody Perfil perfil) {
        log.info("Create a perfil");

        return perfilService.createPerfil(perfil);
    }

    @DeleteMapping()
    public String deletePerfil(@RequestBody Perfil perfil){
        log.info("Delete a perfil ");
        return perfilService.deletePerfil(perfil);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

        log.info("Delete a perfil ");

        Optional<Perfil> perfil = perfilService.getOnePerfil(id);
        if(perfil.isPresent()){
            perfilService.deletePerfil(perfil.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
