package br.com.fametro.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva {
	
	@Id
	@SequenceGenerator(name="seq_reserva", initialValue=1)
	@GeneratedValue(generator="seq_reserva", strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	@OneToOne
	@JoinColumn(name = "sala_id")
	private SalaAula salaAula;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="data_da_reserva")
	private Date dataReserva;

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

	public Date getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
}
