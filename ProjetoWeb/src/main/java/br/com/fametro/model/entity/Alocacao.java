package br.com.fametro.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Alocacao {
	
	@Id
	@SequenceGenerator(name="seq_alocacao", initialValue=1)
	@GeneratedValue(generator="seq_alocacao", strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	@OneToOne
	@JoinColumn(name = "sala_id")
	private SalaAula salaAula;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public SalaAula getSalaAula() {
		return salaAula;
	}
	public void setSalaAula(SalaAula salaAula) {
		this.salaAula = salaAula;
	}
}
