package br.com.fametro.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reserva_sala")
public class ReservaSala extends Reserva{
	
	@ManyToOne
	@JoinColumn(name="professor")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name="sala")
	private SalaAula sala;

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public SalaAula getSala() {
		return sala;
	}

	public void setSala(SalaAula sala) {
		this.sala = sala;
	}
	
	
}
