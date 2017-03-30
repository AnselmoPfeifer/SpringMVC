package com.anselmopfeifer.service;

import java.util.Collection;

import com.anselmopfeifer.model.Cliente;

import com.anselmopfeifer.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by anselmo on 02/01/17.
 */
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente) {
       return clienteRepository.save(cliente);
    }

    public Collection<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void excluir (Cliente cliente){
        clienteRepository.delete(cliente);
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findOne(id);
    }

    public Cliente alterar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}