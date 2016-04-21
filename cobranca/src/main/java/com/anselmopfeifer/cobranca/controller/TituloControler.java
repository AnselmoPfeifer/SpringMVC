package com.anselmopfeifer.cobranca.controller;

import com.anselmopfeifer.cobranca.model.Titulo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by anselmo on 17/04/16.
 */
@Controller
@RequestMapping("/titulos")
public class TituloControler {

    @RequestMapping("/novo")
    public String novo(){
        return "CadastroTitulo";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String salvar(Titulo titulo){
        System.out.println(">>> " + titulo.getDescricao());
        return "CadastroTitulo";
    }

}
