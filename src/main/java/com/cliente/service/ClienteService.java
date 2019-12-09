package com.cliente.service;

import com.cliente.domain.Cliente;
import com.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllCliente(){

        return clienteRepository.findAll();
    }

    public Optional <Cliente> getOneCliente(Long id){

        return clienteRepository.findById(id);
    }

    public Cliente createCliente(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    public String deleteCliente(Cliente cliente){
        clienteRepository.delete(cliente);
        return "Delete of sucess";
    }


}
