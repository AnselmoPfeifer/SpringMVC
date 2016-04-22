package com.anselmopfeifer.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anselmopfeifer.cobranca.model.StatusTitulo;
import com.anselmopfeifer.cobranca.model.Titulo;
import com.anselmopfeifer.cobranca.repository.Titulos;

/**ß
 * Created by anselmo on 17/04/16.
 */
@Controller
@RequestMapping("/titulos")
public class TituloControler {
	
	@Autowired
	private Titulos titulos;
    
    
    @RequestMapping("/novo")
    public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;
    }
    
//	@RequestMapping("/lista")
//    public ModelAndView lista(){
//		ModelAndView mv = new ModelAndView("ListaTitulo");
//		return mv;
//    }
	
    @RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		titulos.save(titulo);
		
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Título salvo com sucesso!");
		return mv;
	}
    
    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo(){
    	return Arrays.asList(StatusTitulo.values());
    }
        
    
}