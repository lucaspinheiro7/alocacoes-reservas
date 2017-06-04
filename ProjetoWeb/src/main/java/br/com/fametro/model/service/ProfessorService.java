package br.com.fametro.model.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import br.com.fametro.model.dao.LaboratorioDAO;
import br.com.fametro.model.dao.ProfessorDAO;
import br.com.fametro.model.dao.ReservaLabDAO;
import br.com.fametro.model.dao.SalaAulaDAO;
import br.com.fametro.model.dao.TurmaDAO;
import br.com.fametro.model.entity.Laboratorio;
import br.com.fametro.model.entity.Professor;
import br.com.fametro.model.entity.ReservaLab;
import br.com.fametro.model.entity.SalaAula;
import br.com.fametro.model.entity.Turma;


@Service
public class ProfessorService {
	
	@Inject
	private ProfessorDAO profDAO;
	
	@Inject
	private LaboratorioDAO labDAO;
	
	@Inject
	private SalaAulaDAO salaDAO;
	
	@Inject
	private ReservaLabDAO reservaLabDAO;
	
	@Inject
	private TurmaDAO turmaDAO;
	
	public void salvar(Professor prof){
		profDAO.salvar(prof);
	}
	
	public List<Laboratorio> buscarTodosLaboratorios(){
		
		List<Laboratorio> labs = labDAO.buscarTodos();
		
		return labs;
	}
	
	public List<ReservaLab> buscarReservasProf(Professor prof){
		
		
		List<ReservaLab> todasReservas = reservaLabDAO.buscarTodos();
		List<ReservaLab> reservasProf = new ArrayList<ReservaLab>();
		
		for (ReservaLab r : todasReservas){
			
			if (r.getProfessor().getNome().equals(prof.getNome())){
				
				reservasProf.add(r);
			}
			
		}
		
		return reservasProf;
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
	
	public List<SalaAula> buscarSalasProf(Professor prof){
		
		List<Turma> turmasOcupadas = buscarTurmasOcupadas();
		List<SalaAula> salasProf = new ArrayList<SalaAula>();
		
		for (Turma t : turmasOcupadas){
			
			if (t.getProfessor().getNome().equals(prof.getNome())){
				
				SalaAula salaProf = buscarPorNumero(t.getSala());
				salasProf.add(salaProf);
			}
		}
		
		return salasProf;
	}
	
	public List<Turma> buscarTurmasProf(Professor prof){
		
		List<Turma> todasTurmas = turmaDAO.buscarTodos();
		List<Turma> turmasProf = new ArrayList<Turma>();
		
		for (Turma t : todasTurmas) {
			
			if (t.getProfessor().getNome().equals(prof.getNome())){
				
				turmasProf.add(t);
			}
			
		}
		
		return turmasProf;
	}
	
	public Turma buscarTurmaPorSala(SalaAula sala){
		
		List<Turma> turmasOcupadas = buscarTurmasOcupadas();
		
		for (Turma t : turmasOcupadas) {
			
			if (t.getSala().getNumero() == sala.getNumero()){
				
				return t;
				
			}
			
		}
		
		return null;
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

	public List<Laboratorio> buscarLabsDisponiveis(){
		
		List<Laboratorio> todosLabs = labDAO.buscarTodos();
		List<Laboratorio> labsDisponiveis = new ArrayList<Laboratorio>();
		
		for (Laboratorio l : todosLabs){
			
			if (l.getStatus().equals("disponível")){
				
				labsDisponiveis.add(l);
				
			}
			
		}
		
		return labsDisponiveis;
	}	

	public List<ReservaLab> buscarReservasPorLab(Laboratorio lab){
		
		List<ReservaLab> todasReservas = reservaLabDAO.buscarTodos();
		List<ReservaLab> reservasLab = new ArrayList<ReservaLab>();
		
		for (ReservaLab r : todasReservas){
			
			if (r.getLaboratorio().getNumero() == lab.getNumero()){
				
				reservasLab.add(r);
				
			}
		}
		
		return reservasLab;
	}
		
	public Map<String, Object> reservarLab(Laboratorio lab, ReservaLab reservaLab, Professor prof) throws ParseException{
		
		Date hoje = new Date();
		
		String msgError = "RESERVA NÃO REALIZADA: DATA ULTRAPASSADA!";
		String msgSucess = null;
		
		Map<String, Object> mensagens = new HashMap<String, Object>();
		
		List<ReservaLab> todasReservas = buscarReservasPorLab(lab);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		hoje = format.parse(format.format(hoje));
		//Formatação necessária para zerar o horario e focar apenas na data
		
		if (reservaLab.getDataReserva().compareTo(hoje) >= 0){
			//Verifica se data selecionada está ultrapassada
			
			for(ReservaLab r : todasReservas){
				
				if (r.getDataReserva().getTime() == reservaLab.getDataReserva().getTime()){
					//verifica se já existe uma reserva para a data solicitada
					
					msgError = "RESERVA NÃO REALIZADA: JÁ EXISTE UMA RESERVA PARA ESTA DATA";
					
					mensagens.put("msgSucess", msgSucess);
					mensagens.put("msgError", msgError);
					
					return mensagens;
					
				}
				
			}
			
			
			msgSucess = "RESERVA REALIZADA COM SUCESSO!";
			msgError = null;
			
			lab = buscarPorNumero(lab);
			reservaLab.setLaboratorio(lab);
			reservaLab.setProfessor(prof);
			reservaLabDAO.salvar(reservaLab);
			
			mensagens.put("msgSucess", msgSucess);
			mensagens.put("msgError", msgError);
			
		}
		
		mensagens.put("msgSucess", msgSucess);
		mensagens.put("msgError", msgError);
		
		return mensagens;
	}

}

