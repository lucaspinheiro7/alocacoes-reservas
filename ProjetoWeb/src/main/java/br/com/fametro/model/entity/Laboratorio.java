package br.com.fametro.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Laboratorio extends Sala {
	
	public Laboratorio(){
		this.status = "disponível";
	}
	
	@OneToMany(mappedBy = "laboratorio", targetEntity = ReservaLab.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ReservaLab> reservasLab;
}
