package com.cliente.service;

import com.cliente.domain.Cliente;
import com.cliente.domain.Email;
import com.cliente.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public List<Email> getAllEmail(){
        return emailRepository.findAll();
    }

    public Optional<Email> getOneEmail(Long id){

        return emailRepository.findById(id);
    }

    public List<Email> findEmail(String descricao){

        return emailRepository.findEmailByDescricao(descricao);
    }

    public Email createEmail(Email email){

        return emailRepository.save(email);
    }

    public String deleteEmail(Email email){
        emailRepository.delete(email);
        return "Delete of sucess";
    }

}
