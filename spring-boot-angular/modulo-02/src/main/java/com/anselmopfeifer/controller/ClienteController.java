package com.anselmopfeifer.controller;

import java.util.Collection;

import com.anselmopfeifer.model.Cliente;
import com.anselmopfeifer.service.ClienteService;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by anselmo on 02/01/17.
 */
@RestController
public class ClienteController {

    private static final String HOME = "revisao-js.html";

    @Autowired
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

        Cliente clienteCadastrado = clienteService.cadastrar(cliente);
        return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {

        Collection<Cliente> clientesBuscados = clienteService.buscarTodos();

        return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}" )
    public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

        Cliente clienteEncontrado = clienteService.buscarPorId(id);
        if (clienteEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clienteService.excluir(clienteEncontrado);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {

        Cliente clienteAlterado = clienteService.alterar(cliente);
        return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
    }

}