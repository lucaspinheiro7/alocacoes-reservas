package br.com.fametro.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fametro.model.entity.Turma;
import br.com.fametro.model.service.AdministradorService;

@Controller
@RequestMapping("/administrador")
public class AdminController {
	
	@Inject
	AdministradorService adminService;
	
	@RequestMapping("/inicio")
	public ModelAndView inicio(){
		
		//String msg = "teste";
		
		//return new ModelAndView("/administrador/inicio", "msg", msg);
		List<Turma> turmas = adminService.buscarTurmasDisponiveis(); 

		return new ModelAndView("/administrador/inicio", "turmas", turmas);	
	}
	
	@RequestMapping("/alocacao-automatica")
	public ModelAndView alocacaoAutomatica(){
		
		String message = "Alocacao automatica";
		
		return new ModelAndView("/administrador/alocacao-automatica", "message", message);
	}

}
