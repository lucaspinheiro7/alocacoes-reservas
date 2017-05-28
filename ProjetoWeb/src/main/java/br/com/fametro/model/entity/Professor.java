package br.com.fametro.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Usuario {
	
	@ManyToOne
	@JoinColumn(name="curso")
	private Curso curso;
	
	@OneToMany(mappedBy = "professor", targetEntity = Turma.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Turma> turmas;
	
	@OneToMany(mappedBy = "professor", targetEntity = ReservaLab.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ReservaLab> reservasLab;
	
	@OneToMany(mappedBy = "professor", targetEntity = ReservaSala.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ReservaSala> reservasSala;

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	
	public List<ReservaLab> getReservasLab() {
		return reservasLab;
	}
	public void setReservasLab(List<ReservaLab> reservasLab) {
		this.reservasLab = reservasLab;
	}
	
	public List<ReservaSala> getReservasSala() {
		return reservasSala;
	}
	public void setReservasSala(List<ReservaSala> reservasSala) {
		this.reservasSala = reservasSala;
	}
}
