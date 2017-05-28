package br.com.fametro.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class Reserva {
	
	@Id
	@SequenceGenerator(name="seq_reserva", initialValue=1)
	@GeneratedValue(generator="seq_reserva", strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="data_reserva")
	private Date dataReserva;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Date getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
}
