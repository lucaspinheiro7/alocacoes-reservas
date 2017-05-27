package br.com.fametro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/administrador")
public class AdminController {
	
	@RequestMapping("/inicio")
	public ModelAndView Inicio(){
		
		String message = "Welcome to Spring mvc 4.0";
		
		return new ModelAndView("/administrador/inicio", "message", message);
		
	}
	
	@RequestMapping("/alocacao-automatica")
	public ModelAndView alocacaoAutomatica(){
		
		String message = "Alocacao automatica";
		
		return new ModelAndView("/administrador/alocacao-automatica", "message", message);
	}

}
