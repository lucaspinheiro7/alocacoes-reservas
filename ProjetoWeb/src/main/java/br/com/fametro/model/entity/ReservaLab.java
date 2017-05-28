package br.com.fametro.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reserva_lab")
public class ReservaLab extends Reserva{
	
	@ManyToOne
	@JoinColumn(name="professor")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name="laboratorio")
	private Laboratorio laboratorio;

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	
}
