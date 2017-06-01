package br.com.fametro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fametro.model.entity.Laboratorio;
import br.com.fametro.model.entity.SalaAula;
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
	public ModelAndView alocacaoAutomatica(Map<String, Object> mensagens){
		
		return new ModelAndView("/administrador/alocacao-automatica", mensagens);
	}
	
	@RequestMapping("/alocacao-manual")
	public ModelAndView alocacaoManual(){
	
		return new ModelAndView("/administrador/alocacao-manual");
	}
	
	@RequestMapping("/salas")
	public ModelAndView salas(){
		
		List<SalaAula> salas = adminService.buscarTodasSalas();
		List<Laboratorio> labs = adminService.buscarTodosLaboratorios();
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("salas", salas);
		models.put("labs", labs);
		
		return new ModelAndView("/administrador/salas", models);
	}
	
	@RequestMapping("turmas")
	public ModelAndView turmas(){
		
		List<Turma> turmas = adminService.buscarTodasTurmas();
		
		return new ModelAndView("/administrador/turmas", "turmas", turmas);
	}
	
	@RequestMapping("/turmas-gerenciar")
	public ModelAndView gerenciarTurma(Turma turma){
		
		Turma turmaSelected = adminService.buscarPorDisciplina(turma);
		
		return new ModelAndView("administrador/turmas-gerenciar", "turmaSelect", turmaSelected);
	}
	
	@RequestMapping("salas-gerenciar")
	public ModelAndView gerenciarSala(SalaAula sala){
		
		SalaAula salaSelected = adminService.buscarPorNumero(sala);
		
		return new ModelAndView("/administrador/salas-gerenciar", "salaSelect", salaSelected);
	}
	
	@RequestMapping("laboratorios-gerenciar")
	public ModelAndView gerenciarSala(Laboratorio laboratorio){
		
		Laboratorio labSelected = adminService.buscarPorNumero(laboratorio);
		
		return new ModelAndView("/administrador/laboratorios-gerenciar", "labSelect", labSelected);
	}
	
	@RequestMapping("/alocar-automaticamente")
	public ModelAndView alocarAutomaticamente(){
		
		Map<String, Object> mensagens = new HashMap<String, Object>();
		
		mensagens = adminService.alocarAutomaticamente();
		
		return alocacaoAutomatica(mensagens);
	}
	
	@RequestMapping("/interditar-sala")
	public ModelAndView interditarSala(SalaAula sala){
		
		SalaAula salaInterditada = adminService.interditarSala(sala);
		
		return gerenciarSala(salaInterditada);
	}

}
