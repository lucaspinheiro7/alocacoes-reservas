package br.com.fametro.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.fametro.model.dao.AdministradorDAO;
import br.com.fametro.model.dao.TurmaDAO;
import br.com.fametro.model.entity.Administrador;
import br.com.fametro.model.entity.Turma;

@Service
public class AdministradorService {
	
	@Inject
	private AdministradorDAO adminDAO;
	
	@Inject
	private TurmaDAO turmaDAO;
	
	public void salvar(Administrador administrador){
		adminDAO.salvar(administrador);
	}
	
	public List<Turma> buscarTurmasDisponiveis(){
		
		List<Turma> todasTurmas = turmaDAO.buscarTodos();
		List<Turma> turmasDisponiveis = new ArrayList<Turma>();
		
		for (Turma t : todasTurmas){
			
			if (t.getStatus().equals("disponível")){
				
				turmasDisponiveis.add(t);
				
			}
			
		}
		
		return turmasDisponiveis;
	}
	
	public Turma buscarPorDisciplina(Turma turma){
		
		List<Turma> todasTurmas = turmaDAO.buscarTodos();
		//Busca todas as turmas do banco
		
		for(Turma t : todasTurmas){
			
			System.out.println("COMPARAÇÃO:  \n"
					+ t.getDisciplina() + " = " + turma.getDisciplina() + " ??? \n");
			if (turma.getDisciplina().equals(t.getDisciplina())){
				//Verifica qual turma tem o mesmo nome da que foi passada por parametro
				
				turma.setId(t.getId());
				turma.setCurso(t.getCurso());
				turma.setProfessor(t.getProfessor());
				turma.setQuantAlunos(t.getQuantAlunos());
				turma.setSala(t.getSala());
				turma.setStatus(t.getStatus());
				//passa os atributos da turma encontrada para o objeto que sera retornado

				break;	
			}
			
		}
		
		return turma;
	}
}
