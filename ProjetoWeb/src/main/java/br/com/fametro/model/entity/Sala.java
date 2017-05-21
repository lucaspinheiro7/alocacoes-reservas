package br.com.fametro.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Sala {
	
	@Id
	@SequenceGenerator(name="seq_sala", initialValue=1)
	@GeneratedValue(generator="seq_sala", strategy=GenerationType.AUTO)
	private long id;
	private int numero;
	private int capacidade;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}	
}
