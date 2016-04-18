package com.anselmopfeifer.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by anselmo on 17/04/16.
 */
@Controller
public class TituloControler {

    @RequestMapping("/titulos/novo")
    public String novo(){
        return "CadastroTitulo";
    }

}
