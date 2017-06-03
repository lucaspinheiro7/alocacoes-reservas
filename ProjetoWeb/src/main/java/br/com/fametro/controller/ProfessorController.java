package br.com.fametro.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fametro.model.entity.Laboratorio;
import br.com.fametro.model.entity.Professor;
import br.com.fametro.model.entity.ReservaLab;
import br.com.fametro.model.entity.SalaAula;
import br.com.fametro.model.entity.Turma;
import br.com.fametro.model.service.ProfessorService;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Inject
	ProfessorService profService;
	
	/**
	 * 
	 * @return /views/professor/inicio.jsp
	 */
	@RequestMapping("/inicio")
	public ModelAndView inicio(){
		
		List<Laboratorio> labs =  profService.buscarTodosLaboratorios();

		return new ModelAndView("/professor/inicio", "labs", labs);	
	}
	
	@RequestMapping("/minhas-reservas")
	public ModelAndView minhasReservas(HttpSession session){
		
		Professor prof = (Professor)session.getAttribute("profAutenticado");
		
		List<ReservaLab> reservas = profService.buscarReservasProf(prof);
		
		return new ModelAndView("/professor/minhas-reservas", "reservas", reservas);
	}
	
	@RequestMapping("/salas")
	public ModelAndView salas(HttpSession session){
		
		Professor prof = (Professor)session.getAttribute("profAutenticado");
		
		List<SalaAula> salasProf = profService.buscarSalasProf(prof);
		
		return new ModelAndView("/professor/salas", "salas", salasProf);
	}
	
	@RequestMapping("/salas-informacoes")
	public ModelAndView gerenciarSala(SalaAula sala){
		
		SalaAula salaSelected = profService.buscarPorNumero(sala);
		Turma turma = profService.buscarTurmaPorSala(sala);
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("sala", salaSelected);
		models.put("turma", turma);
		
		return new ModelAndView("/professor/salas-informacoes", models);
	}
	
	@RequestMapping("/turmas")
	public ModelAndView turmas(HttpSession session){
		
		Professor prof = (Professor)session.getAttribute("profAutenticado");
		
		List<Turma> turmasProf = profService.buscarTurmasProf(prof);
		
		return new ModelAndView("/professor/turmas", "turmas", turmasProf);
	}
	
	@RequestMapping("/turmas-informacoes")
	public ModelAndView gerenciarTurma(Turma turma){
		
		Turma turmaSelected = profService.buscarPorDisciplina(turma);
		
		return new ModelAndView("professor/turmas-informacoes", "turma", turmaSelected);
	}
	
}
