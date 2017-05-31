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
		
		List<Turma> turmas = adminService.buscarTurmasDisponiveis(); 

		return new ModelAndView("/administrador/inicio", "turmas", turmas);	
	}
	
	@RequestMapping("/alocacao-automatica")
	public ModelAndView alocacaoAutomatica(){
		
		return new ModelAndView("/administrador/alocacao-automatica");
	}
	
	@RequestMapping("/alocacao-manual")
	public ModelAndView alocacaoManual(){
	
		return new ModelAndView("/administrador/alocacao-manual");
	}
	
	@RequestMapping("/salas")
	public ModelAndView salas(){
		
		return new ModelAndView("/administrador/salas");
	}
	
	@RequestMapping("turmas")
	public ModelAndView turmas(){
		return new ModelAndView("/administrador/turmas");
	}
	
	@RequestMapping("/gerenciar-turma")
	public ModelAndView gerenciarTurma(Turma turma){
		
		Turma turmaSelected = adminService.buscarPorDisciplina(turma);
		
		return new ModelAndView("/administrador/inicio-gerenciar", "turmaSelect", turmaSelected);
	}

}
