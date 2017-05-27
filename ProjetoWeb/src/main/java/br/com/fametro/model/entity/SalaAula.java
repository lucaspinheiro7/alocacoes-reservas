package br.com.fametro.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sala")
public class SalaAula extends Sala{
	public SalaAula(){
		this.status = "disponível";
	}	
}
