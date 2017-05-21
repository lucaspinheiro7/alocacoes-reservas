package br.com.fametro.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Disciplina {
	
	@Id
	@SequenceGenerator(name="seq_disciplina",initialValue=1)
	@GeneratedValue(generator="seq_disciplina", strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
