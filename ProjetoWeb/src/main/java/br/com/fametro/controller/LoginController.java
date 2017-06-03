package br.com.fametro.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fametro.model.entity.Administrador;
import br.com.fametro.model.entity.Laboratorio;
import br.com.fametro.model.entity.Professor;
import br.com.fametro.model.entity.Turma;
import br.com.fametro.model.service.AdministradorService;
import br.com.fametro.model.service.LoginService;
import br.com.fametro.model.service.ProfessorService;

@Controller
public class LoginController {
	
	@Inject
	LoginService loginService;
	
	@Inject
	AdministradorService adminService;
	
	@Inject
	ProfessorService profService;
	
	@RequestMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("../login");
	}
	
	@RequestMapping("/loginError")
	public ModelAndView loginError(){
		String msg = "Login ou senha Incorretos!";
		return new ModelAndView("../login", "msg", msg);
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session){
		
		session.invalidate();
		
		return new ModelAndView("../login");
	}
	
	@RequestMapping(value = "/autenticacao", method = RequestMethod.POST)
	public ModelAndView autenticacao(@RequestParam(value = "identificador") String id, Professor prof, Administrador admin, HttpSession session){
	
		int identificador = Integer.parseInt(id);
		
		if (identificador == 1){
			
			Administrador adminAutenticado = loginService.validar(admin);
			
			if (adminAutenticado != null){
				
				List<Turma> turmas = adminService.buscarTurmasDisponiveis(); 
				
				session.setAttribute("adminAutenticado", adminAutenticado);
			    
			   return new ModelAndView("/administrador/inicio", "turmas", turmas);
			}

		} else if (identificador == 2){
			
			Professor profAutenticado = loginService.validar(prof);
			
			if (profAutenticado != null){
				
				session.setAttribute("profAutenticado", profAutenticado);
			    
				List<Laboratorio> labs = profService.buscarTodosLaboratorios();
				
				return new ModelAndView("/professor/inicio", "labs", labs);
			}
		}
		
		return loginError();
	}
}
