package br.com.fametro.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Turma {
	
	@Id
	@SequenceGenerator(name="seq_turma", initialValue=1)
	@GeneratedValue(generator="seq_turma", strategy=GenerationType.AUTO)
	private long id;
	private int quant_alunos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuant_alunos() {
		return quant_alunos;
	}
	public void setQuant_alunos(int quant_alunos) {
		this.quant_alunos = quant_alunos;
	}
}
