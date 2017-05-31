package br.com.fametro.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@JoinColumn(name="professor")
	private Professor professor;
	
	@OneToOne
	@JoinColumn(name="sala")
	private SalaAula sala;
	
	@ManyToOne
	@JoinColumn(name="curso")
	private Curso curso;
	
	public Turma(){
		this.status = "disponível";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getQuantAlunos() {
		return quantAlunos;
	}
	public void setQuantAlunos(int quantAlunos) {
		this.quantAlunos = quantAlunos;
	}

	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public SalaAula getSala() {
		return sala;
	}
	public void setSala(SalaAula sala) {
		this.sala = sala;
	}

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}