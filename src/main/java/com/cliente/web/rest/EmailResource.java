package com.cliente.web.rest;

import com.cliente.domain.Email;
import com.cliente.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/email")
public class EmailResource {

    @Autowired
    private EmailRepository emailRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Email> getAllEmails(){
        return emailRepository.findAll();
    }

    @PostMapping()
    public Email createEmail(@RequestBody @Valid Email email){
        return emailRepository.save(email);
    }

    @DeleteMapping()
    public Email deleteEmail(@RequestBody Email email){
        emailRepository.delete(email);
        return email;
    }
}
