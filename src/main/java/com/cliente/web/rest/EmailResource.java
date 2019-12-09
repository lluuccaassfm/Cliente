package com.cliente.web.rest;

import com.cliente.domain.Email;
import com.cliente.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/email")
public class EmailResource {

    private final Logger log = LoggerFactory.getLogger(EmailResource.class);

    private final EmailService emailService;

    public EmailResource(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<List<Email>> findEmail(@Param("descricao") String descricao){

        if(descricao == null){
            log.info("Get all emails");
            return new ResponseEntity<>(emailService.getAllEmail(),HttpStatus.OK);
        }else{
            List<Email> emails = emailService.findEmail(descricao);
            if(emails.size() > 0){
                return new ResponseEntity<>(emails,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Email> getById(@PathVariable(value = "id") Long id) {
        log.info("Get one email");
        Optional<Email> email = emailService.getOneEmail(id);
        if(email.isPresent())
            return new ResponseEntity<Email>(email.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public Email Post(@Valid @RequestBody Email email) {
        log.info("Create a email");

        return emailService.createEmail(email);
    }

    @DeleteMapping()
    public String deleteEmail(@RequestBody Email email){
        log.info("Delete a email ");
        return emailService.deleteEmail(email);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmail(@PathVariable(value = "id") long id) {

        log.info("Delete a email ");

        Optional<Email> email = emailService.getOneEmail(id);
        if(email.isPresent()){
            emailService.deleteEmail(email.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
