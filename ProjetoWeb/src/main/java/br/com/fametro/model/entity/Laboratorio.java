package br.com.fametro.model.entity;

import javax.persistence.Entity;

@Entity
public class Laboratorio extends Sala {
	
	public Laboratorio(){
		this.status = "disponível";
	}
}
