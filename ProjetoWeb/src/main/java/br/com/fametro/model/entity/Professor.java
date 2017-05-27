package br.com.fametro.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Professor extends Usuario {
	
	@ManyToOne
	@JoinColumn(name="curso")
	private Curso curso;

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}	
}
