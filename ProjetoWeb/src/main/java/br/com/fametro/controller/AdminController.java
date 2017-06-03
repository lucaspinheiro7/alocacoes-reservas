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

/**
 * 
 * Controlador de Páginas do Administrador
 * @author Lucas P. Fraça
 *
 */

@Controller
@RequestMapping("/administrador")
public class AdminController {
	
	@Inject
	AdministradorService adminService;
	
	/**
	 * 
	 * @return /views/administrador/inicio.jsp
	 */
	@RequestMapping("/inicio")
	public ModelAndView inicio(){
		
		List<Turma> turmas = adminService.buscarTurmasDisponiveis(); 

		return new ModelAndView("/administrador/inicio", "turmas", turmas);	
	}
	 
	
	/**
	 * 
	 * @return /views/administrador/alocacao-manual.jsp
	 */
	@RequestMapping("/alocacao-manual")
	public ModelAndView alocacaoManual(){
		
		List<Turma> turmas = adminService.buscarTurmasDisponiveis();
		List<SalaAula> salas = adminService.buscarSalasDisponiveis();
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("turmas", turmas);
		models.put("salas", salas);
		
	
		return new ModelAndView("/administrador/alocacao-manual", models);
	}
	
	@RequestMapping("/alocacao-manual-turma")
	public ModelAndView alocacaoManualTurma(Turma turma){
		
		
		Turma turmaSelected = adminService.buscarPorDisciplina(turma);
		List<SalaAula> salas = adminService.buscarSalasDisponiveis();
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("turma", turmaSelected);
		models.put("salas", salas);
		
		return new ModelAndView("/administrador/alocacao-manual-turma", models);
	}
	
	@RequestMapping("/alocacao-manual-sala")
	public ModelAndView alocacaoManualSala(SalaAula sala){
		
		SalaAula salaSelected = adminService.buscarPorNumero(sala);
		List<Turma> turmas = adminService.buscarTurmasDisponiveis();
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("sala", salaSelected);
		models.put("turmas", turmas);
		
		return new ModelAndView("/administrador/alocacao-manual-sala", models);
	}
	
	@RequestMapping("/realocacao")
	public ModelAndView realocacaoTurma(Turma turma){
		
		Turma turmaSelected = adminService.buscarPorDisciplina(turma);
		List<SalaAula> salas = adminService.buscarSalasDisponiveis();
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("turma", turmaSelected);
		models.put("salas", salas);
		
		return new ModelAndView("/administrador/realocacao", models);
	}
	
	
	/**
	 * 
	 * @return /views/administrador/alocacao-automatica.jsp
	 */
	@RequestMapping("/alocacao-automatica")
	public ModelAndView alocacaoAutomatica(){
		
		return new ModelAndView("/administrador/alocacao-automatica");
	}
	
	
	/**
	 * 
	 * @return /views/administrador/salas.jsp
	 */
	@RequestMapping("/salas")
	public ModelAndView salas(){
		
		List<SalaAula> salas = adminService.buscarTodasSalas();
		List<Laboratorio> labs = adminService.buscarTodosLaboratorios();
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("salas", salas);
		models.put("labs", labs);
		
		return new ModelAndView("/administrador/salas", models);
	}
	
	/**
	 * 
	 * @return /views/administrador/turams.jsp
	 */
	@RequestMapping("/turmas")
	public ModelAndView turmas(){
		
		List<Turma> turmas = adminService.buscarTodasTurmas();
		
		return new ModelAndView("/administrador/turmas", "turmas", turmas);
	}
	

	@RequestMapping("/turmas-gerenciar")
	public ModelAndView gerenciarTurma(Turma turma){
		
		Turma turmaSelected = adminService.buscarPorDisciplina(turma);
		
		return new ModelAndView("administrador/turmas-gerenciar", "turma", turmaSelected);
	}
	
	/**
	 * 
	 * @param sala
	 * @return /views/administrador/salas-gerenciar.jsp
	 */
	@RequestMapping("/salas-gerenciar")
	public ModelAndView gerenciarSala(SalaAula sala){
		
		SalaAula salaSelected = adminService.buscarPorNumero(sala);
		
		return new ModelAndView("/administrador/salas-gerenciar", "sala", salaSelected);
	}
	
	/**
	 * 
	 * @param laboratorio
	 * @return views/administrador/laboratorios-gerenciar.jsp
	 */
	@RequestMapping("/laboratorios-gerenciar")
	public ModelAndView gerenciarSala(Laboratorio laboratorio){
		
		Laboratorio labSelected = adminService.buscarPorNumero(laboratorio);
		
		return new ModelAndView("/administrador/laboratorios-gerenciar", "lab", labSelected);
	}
	
	@RequestMapping("/reserva-laboratorio")
	public ModelAndView reservarLab(Laboratorio lab){
		
		Laboratorio labSelected = adminService.buscarPorNumero(lab);
		List<Turma> turmas = adminService.buscarTurmasDisponiveis();
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("lab",labSelected);
		models.put("turmas", turmas);
		
		return new ModelAndView("/administrador/reserva-laboratorio", models);
	}
	
	/**
	 * 
	 * @return /views/administrador/alocacao-automatica.jsp
	 */
	@RequestMapping("/alocar-automaticamente")
	public ModelAndView alocarAutomaticamente(){
		
		Map<String, Object> mensagens = new HashMap<String, Object>();
		
		mensagens = adminService.alocarAutomaticamente();
		
		return new ModelAndView("/administrador/alocacao-automatica", mensagens);
	}
	
	/**
	 * 
	 * @param turma
	 * @param sala
	 * @return /views/administrador/alocacao-manual.jsp
	 */
	@RequestMapping("/alocar-manualmente")
	public ModelAndView alocarManualmente(Turma turma, SalaAula sala){
		
		Map<String, Object> mensagens  = adminService.alocarManualmente(turma, sala);
		List<Turma> turmas = adminService.buscarTurmasDisponiveis();
		List<SalaAula> salas = adminService.buscarSalasDisponiveis();
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("turmas", turmas);
		models.put("salas", salas);
		models.put("mensagens", mensagens);
		
		return new ModelAndView("/administrador/alocacao-manual", models);
	}
	
	
	
	/**
	 * 
	 * @param turma
	 * @param sala
	 * @return /views/administrador/alocacao-manual-turma.jsp
	 */
	@RequestMapping("/alocar-manualmente-turma")
	public ModelAndView alocarManualmenteTurma(Turma turma, SalaAula sala){
		
		Turma turmaSelected = adminService.buscarPorDisciplina(turma);
		Map<String, Object> mensagens  = adminService.alocarManualmente(turmaSelected, sala);
		
		List<SalaAula> salas = adminService.buscarSalasDisponiveis();

		
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("turma", turmaSelected);
		models.put("salas", salas);
		models.put("mensagens", mensagens);
		
		return new ModelAndView("/administrador/alocacao-manual-turma", models);
	}
	
	@RequestMapping("/alocar-manualmente-sala")
	public ModelAndView alocarManualmenteSala(Turma turma, SalaAula sala){
		
		SalaAula salaSelected = adminService.buscarPorNumero(sala);
		
		Map<String, Object> mensagens  = adminService.alocarManualmente(turma, salaSelected);
		
		List<Turma> turmas = adminService.buscarTurmasDisponiveis();

		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("sala", salaSelected);
		models.put("turmas", turmas);
		models.put("mensagens", mensagens);
		
		return new ModelAndView("/administrador/alocacao-manual-sala", models);
	}
	
	@RequestMapping("/realocar-turma")
	public ModelAndView realocarTurma(Turma turma, SalaAula sala){
		
		
		Turma turmaSelected = adminService.buscarPorDisciplina(turma);
		
		Map<String, Object> mensagens  = adminService.realocarTurma(turmaSelected, sala);
		List<SalaAula> salas = adminService.buscarSalasDisponiveis();
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("turma", turmaSelected);
		models.put("salas", salas);
		models.put("mensagens", mensagens);
		
		return new ModelAndView("/administrador/realocacao", models);
	}
	
	
	/**
	 * 
	 * @param sala
	 * @return /views/administrador/salas-gerenciar.jsp
	 */
	@RequestMapping("/interditar-sala")
	public ModelAndView interditarSala(SalaAula sala){
		
		Map<String, Object> models = adminService.interditarSala(sala);
		
		return new ModelAndView("/administrador/salas-gerenciar", models);
	}
	
	@RequestMapping("/interditar-laboratorio")
	public ModelAndView interditarLab(Laboratorio lab){
		
		Map<String, Object> models = adminService.interditarLab(lab);
		
		return new ModelAndView("/administrador/laboratorios-gerenciar", models);
		
	}
	
	/**
	 * 
	 * @param sala
	 * @return /views/administrador/salas-gerenciar.jsp
	 */
	@RequestMapping("/desinterditar-sala")
	public ModelAndView desinterditarSala(SalaAula sala){
		
		Map<String, Object> models = adminService.desinterditarSala(sala);
		
		return new ModelAndView("/administrador/salas-gerenciar", models);
	}
	
	@RequestMapping("/desinterditar-laboratorio")
	public ModelAndView desinterditarLab(Laboratorio lab){
		
		Map<String, Object> models = adminService.desinterditarLab(lab);
		
		return new ModelAndView("/administrador/laboratorios-gerenciar", models);
	}
	
}
