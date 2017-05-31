package br.com.fametro.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sala")
public class SalaAula extends Sala{
	
	public SalaAula(){
		this.status = "disponível";
	}	
	
	@OneToMany(mappedBy = "sala", targetEntity = ReservaSala.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ReservaSala> reservasSala;
}
