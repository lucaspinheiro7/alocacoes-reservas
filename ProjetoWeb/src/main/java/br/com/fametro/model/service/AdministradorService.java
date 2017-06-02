package br.com.fametro.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.fametro.model.dao.AdministradorDAO;
import br.com.fametro.model.dao.LaboratorioDAO;
import br.com.fametro.model.dao.SalaAulaDAO;
import br.com.fametro.model.dao.TurmaDAO;
import br.com.fametro.model.entity.Administrador;
import br.com.fametro.model.entity.Laboratorio;
import br.com.fametro.model.entity.SalaAula;
import br.com.fametro.model.entity.Turma;

@Service
public class AdministradorService {
	
	@Inject
	private AdministradorDAO adminDAO;
	
	@Inject
	private TurmaDAO turmaDAO;
	
	@Inject
	private SalaAulaDAO salaDAO;
	
	@Inject
	private LaboratorioDAO labDAO;
	
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
	
	public List<Turma> buscarTurmasOcupadas(){
		
		List<Turma> todasTurmas = turmaDAO.buscarTodos();
		List<Turma> turmasOcupadas = new ArrayList<Turma>();
		
		for (Turma t : todasTurmas){
			
			if (t.getStatus().equals("ocupada")){
				
				turmasOcupadas.add(t);
				
			}
			
		}
		
		return turmasOcupadas;
	}
	
	public List<SalaAula> buscarSalasDisponiveis(){
		
		List<SalaAula> todasSalas = salaDAO.buscarTodos();
		List<SalaAula> salasDisponiveis = new ArrayList<SalaAula>();
		
		for (SalaAula s : todasSalas){
			
			if (s.getStatus().equals("disponível")){
				
				salasDisponiveis.add(s);
				
			}
			
		}
		
		return salasDisponiveis;
	}
	
	public Turma buscarPorDisciplina(Turma turma){
		
		List<Turma> todasTurmas = turmaDAO.buscarTodos();
		//Busca todas as turmas do banco
		
		for(Turma t : todasTurmas){
			
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
	
	public List<SalaAula> buscarTodasSalas(){
		
		List<SalaAula> salas = salaDAO.buscarTodos();
		
		return salas;
	}
	
	public List<Laboratorio> buscarTodosLaboratorios(){
		
		List<Laboratorio> labs = labDAO.buscarTodos();
		
		return labs;
	}
	
	public List<Turma> buscarTodasTurmas(){
		
		List<Turma> turmas = turmaDAO.buscarTodos();
		
		return turmas;
	}

	public SalaAula buscarPorNumero(SalaAula sala) {
		
		List<SalaAula> todasSalas = salaDAO.buscarTodos();
		//Busca todas as salas do banco
		
		for (SalaAula s : todasSalas){
			
			if (sala.getNumero() == s.getNumero()){
				//Verifica qual sala tem o mesmo numero da que foi passada por parametro
				
				sala.setId(s.getId());
				sala.setNumero(s.getNumero());
				sala.setCapacidade(s.getCapacidade());
				sala.setStatus(s.getStatus());
				//passa os atributos da sala encontrada para o objeto que sera retornado

				break;	
			}
			
		}
		
		return sala;
	}
	
	public Laboratorio buscarPorNumero(Laboratorio laboratorio) {
		
		List<Laboratorio> todosLabs = labDAO.buscarTodos();
		//Busca todas os laboratorios do banco
		
		for (Laboratorio l : todosLabs){

			if (laboratorio.getNumero() == l.getNumero()){
				//Verifica qual laboratorio tem o mesmo numero do que foi passao por parametro
				
				laboratorio.setId(l.getId());
				laboratorio.setNumero(l.getNumero());
				laboratorio.setCapacidade(l.getCapacidade());
				laboratorio.setStatus(l.getStatus());
				//passa os atributos do laboratorio encontrada para o objeto que sera retornado

				break;	
			}
			
		}
		
		return laboratorio;
	}

	public Map<String, Object> alocarAutomaticamente(){
		
		List<Turma> turmasDisponiveis = buscarTurmasDisponiveis(); // traz uma lista com as turmas disponiveis
		List<SalaAula> salasDisponiveis = buscarSalasDisponiveis(); //  traz uma lista com as turmas disponiveis
		int tnAloc = 0;
		int tAloc = 0;
				
		for(Turma t : turmasDisponiveis){
		// Entra na lista de turmas disponíveis e pega uma turma
			
			
			for (SalaAula s : salasDisponiveis){
				// Entra na lista de salas disponíveis e pega uma sala
				
				if (t.getQuantAlunos() <= 20 && s.getCapacidade() <= 20){
					// Verifica se a turma e a sala são pequenas
					
					t.setSala(s);
					t.setStatus("ocupada");
					s.setStatus("ocupada");
					// Aloca a turma na sala
					
					turmaDAO.salvar(t);
					salaDAO.salvar(s);
					// Salva os resultados no banco, fazendo o UPDATE
					
					salasDisponiveis.remove(s);
					// Remove essa sala da lista de salas disponíveis
					
					tAloc += 1;
					// Total de turmas alocadas recebe + 1
					
					break;
					// Sai da lista de salas, e vai buscar outra turma para fazer as verificações
					
				} 
				
				if ( (t.getQuantAlunos() > 20 && t.getQuantAlunos() <= 30) && (s.getCapacidade() > 20 && s.getCapacidade() <= 30) ){
					// Verifica se a turma e a sala são médias
					
					t.setSala(s);
					t.setStatus("ocupada");
					s.setStatus("ocupada");
					
					turmaDAO.salvar(t);
					salaDAO.salvar(s);
					
					salasDisponiveis.remove(s);
					
					tAloc += 1;
					// Total de turmas alocadas recebe + 1
					
					break;
				} 
				
				if (t.getQuantAlunos() > 30 && s.getCapacidade() > 30){
					// Verifica se a turma e a sala são grandes
					
					t.setSala(s);
					t.setStatus("ocupada");
					s.setStatus("ocupada");
					
					turmaDAO.salvar(t);
					salaDAO.salvar(s);
					
					salasDisponiveis.remove(s);
					
					tAloc += 1;
					// Total de turmas alocadas recebe + 1
					
					break;
					
				}
				
			}
			
			if (t.getStatus().equals("disponível")){
				tnAloc += 1; 
				/* 
					 * Se a turma passou por todas as salas e não encontrou compatibilidade,
					 * Total de turmas não alocadas recebe +1 
				 */
			}
		}
		
		Map<String, Object> mensagens = new HashMap<String, Object>();
		
		String msgSucess = null;
		String msgStatus1 = null;
		String msgStatus2 = null;
	
		String msgError = null;
		
		if (tAloc > 0) {
			msgSucess  = "TURMAS ALOCADAS COM SUCESSO! ";
			msgStatus1 = tAloc + " turmas foram alocadas ";
			msgStatus2 = tnAloc + " turmas não foram alocadas";
		} else {
			msgError = "NENHUMA TURMA PODE SER ALOCADA AUTOMATICAMENTE! TENTE A ALOCAÇÃO MANUAL";
		}
		
		mensagens.put("msgSucess", msgSucess);
		mensagens.put("msgStatus1", msgStatus1);
		mensagens.put("msgStatus2", msgStatus2);
		mensagens.put("msgError", msgError);
		
		return mensagens;
	}
	
	public Map<String, Object> alocarManualmente(Turma turma, SalaAula sala){
		
		Turma turmaAlocada = buscarPorDisciplina(turma);
		SalaAula salaAlocada = buscarPorNumero(sala);
		
		String msgError = "TURMA OU SALA INDISPONÍVEL!";
		String msgSucess = null;
		
		if (turmaAlocada.getStatus().equals("disponível") && 
				salaAlocada.getStatus().equals("disponível")){
			
			if (turmaAlocada.getQuantAlunos() <= salaAlocada.getCapacidade()){
				
				turmaAlocada.setSala(salaAlocada);
				turmaAlocada.setStatus("ocupada");
				salaAlocada.setStatus("ocupada");
				turmaDAO.salvar(turmaAlocada);
				salaDAO.salvar(salaAlocada);
				
				msgSucess = "Turma " + turmaAlocada.getDisciplina().toUpperCase() + " Alocada na sala: " + salaAlocada.getNumero() + " com sucesso!";
				msgError = null;
				
			}
			
			msgError = "QUANTIDADE DE ALUNOS MAIOR DO QUE A CAPACIDADE DA SALA";
			
		}
		
		Map<String, Object> mensagens = new HashMap<String, Object>();
		
		mensagens.put("msgSucess", msgSucess);
		mensagens.put("msgError", msgError);
		
		return mensagens;
	}
	
	public Map<String, Object> realocarTurma(Turma turma, SalaAula sala){
		
		Turma turmaAlocada = buscarPorDisciplina(turma);
		SalaAula salaAlocada = buscarPorNumero(sala);
		SalaAula salaOcupada = new SalaAula();
		
		String msgError = "SALA INDISPONÍVEL!";
		String msgSucess = null;
		String msgStatus = null;
		
		salaOcupada.setNumero(turmaAlocada.getSala().getNumero());
		// Objeto salaOcupada recebe o numero da sala que a turma estiver alocada
		
		SalaAula salaDesalocada = buscarPorNumero(salaOcupada);
		// salaDesalocada recebe a sala encontrada no banco
		
		if (salaAlocada.getStatus().equals("disponível")){
			// verifica se apenas se a sala está disponível
			
			if (turmaAlocada.getQuantAlunos() <= salaAlocada.getCapacidade()){
				
				turmaAlocada.setSala(salaAlocada);
				turmaAlocada.setStatus("ocupada");
				salaAlocada.setStatus("ocupada");
				
				salaDesalocada.setStatus("disponível");
				//muda o status da sala que a turma realocada saiu para disponível
				
				turmaDAO.salvar(turmaAlocada);
				salaDAO.salvar(salaAlocada);
				salaDAO.salvar(salaDesalocada);
				
				//Salva os registros no banco de dados
				
				msgSucess = "Turma " + turmaAlocada.getDisciplina().toUpperCase() + " Realocada na sala: " + salaAlocada.getNumero() + " com sucesso!";
				msgStatus = "Sala " + salaDesalocada.getNumero() + " foi desalocada e está disponível!";
				msgError = null;
				
			}
			
			msgError = "QUANTIDADE DE ALUNOS MAIOR DO QUE A CAPACIDADE DA SALA";
			
		}
		
		Map<String, Object> mensagens = new HashMap<String, Object>();
		
		mensagens.put("msgSucess", msgSucess);
		mensagens.put("msgError", msgError);
		mensagens.put("msgStatus", msgStatus);
		
		return mensagens;
	}
	
	public Map<String, Object> interditarSala(SalaAula sala){
		
		SalaAula salaInterditada = buscarPorNumero(sala);
		List<Turma> turmas = buscarTurmasOcupadas();
		String msgSucess = null;
		String msgStatus = null;
		
		for (Turma t : turmas) {
			//Pega a turma do banco 
		
				if (t.getSala().getNumero() == salaInterditada.getNumero()){
					// Verifica se a turma está alocada na sala que será interditada
					
					t.setStatus("disponível");
					t.setSala(null);
					turmaDAO.salvar(t);
					/* A turma fica disponível, uma vez que a sala
					 * que ela estava alocada se interdita */
					
					msgStatus = "Turma : " + t.getDisciplina().toUpperCase() + " foi desalocada e está disponível!";
					
					break;
				}
		}
		
		salaInterditada.setStatus("interditada");
		salaDAO.salvar(salaInterditada);
		// interdita a sala
		
		msgSucess = "SALA INTERDITADA COM SUCESSO!";
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("msgSucess", msgSucess);
		models.put("msgStatus", msgStatus);
		models.put("salaSelect", salaInterditada);
		
		return models;
	}

	public Map<String, Object> desinterditarSala(SalaAula sala){
		
		SalaAula salaDesinterditada = buscarPorNumero(sala);
		String msgSucess = null;
		
		salaDesinterditada.setStatus("disponível");
		salaDAO.salvar(salaDesinterditada);
		// Desinterdita a sala
		
		msgSucess = "SALA DESINTERDITADA COM SUCESSO!";
		
		Map<String, Object> models = new HashMap<String, Object>();
		
		models.put("msgSucess", msgSucess);
		models.put("salaSelect", salaDesinterditada);
		
		return models;	
	}
}
