package br.com.fametro.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Usuario {

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "professor")
	@JoinColumn(name = "professor_id")
	private List<Turma> turmas;

	public List<Turma> getTurma() {
		return turmas;
	}
	public void setTurma(List<Turma> turma) {
		this.turmas = turma;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
