package br.com.fametro.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Turma {
	
	@Id
	@SequenceGenerator(name="seq_turma", initialValue=1)
	@GeneratedValue(generator="seq_turma", strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="quant_alunos")
	private int quantAlunos;
	private String disciplina;
	private String status;
	
	@ManyToOne
	private Curso curso;
	
	@ManyToOne
	private Professor professor;
	
	@OneToOne( cascade = CascadeType.ALL, mappedBy = "turma")
	@Column(name = "sala_de_aula")
	private SalaAula salaAula;
	
	// Ao instanciar: status = "Disponível"
	public Turma(){
		setStatus();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getQuant_alunos() {
		return quantAlunos;
	}
	public void setQuant_alunos(int quantAlunos) {
		this.quantAlunos = quantAlunos;
	}
	
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public String getStatus(){
		return status;
	}
	//Verifica se a turma possui uma sala e define o status
	public void setStatus(){
		if(this.getSalaAula() == null){
			this.status = "Disponível";
		}
		this.status = "Ocupada";
	}
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public SalaAula getSalaAula() {
		return salaAula;
	}
	public void setSalaAula(SalaAula salaAula) {
		this.salaAula = salaAula;
	}	
}
