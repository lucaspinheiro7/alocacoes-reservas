package br.com.fametro.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Curso {
	
	@Id
	@SequenceGenerator(name="seq_curso", initialValue=1)
	@GeneratedValue(generator="seq_curso", strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	
	@Column(name="carga_horaria")
	private int cargaHoraria;
	
	@OneToMany(mappedBy = "curso", targetEntity = Professor.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Professor> professores;
	
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
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}	
}
