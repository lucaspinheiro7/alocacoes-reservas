package br.com.fametro.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Curso {
	
	@Id
	@SequenceGenerator(name="seq_curso", initialValue=1)
	@GeneratedValue(generator="seq_curso", strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "curso")
	@JoinColumn(name = "curso_id")
	private List<Turma> turmas;
	
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
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}	
}
