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
import br.com.fametro.model.entity.Professor;
import br.com.fametro.model.entity.Turma;
import br.com.fametro.model.service.AdministradorService;
import br.com.fametro.model.service.LoginService;

@Controller
public class LoginController {
	
	@Inject
	LoginService loginService;
	
	@Inject
	AdministradorService adminService;
	
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
				
				//Map<String, Object> models = new HashMap<String, Object>();
				
				List<Turma> turmas = adminService.buscarTurmasDisponiveis(); 
				
				session.setAttribute("adminAutenticado", adminAutenticado);
				
				//models.put("adminAutenticado", adminAutenticado);
			    //models.put("turmas", turmas);
			    
			    
			   return new ModelAndView("/administrador/inicio", "turmas", turmas);

			} else {
				return loginError();
			}

		} else if (identificador == 2){
			
			Professor profAutenticado = loginService.validar(prof);
			
			if (profAutenticado != null){
				return new ModelAndView("/professor/inicio", "profAutenticado", profAutenticado);
			}
			return loginError();
		}
		
		return loginError();
	}
}
