package br.com.fametro.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sala_de_aula")
public class SalaAula extends Sala{
	
	@OneToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	public SalaAula(){
		setStatus();
	}
	
	public void setStatus() {
		if(this.getTurma() == null){
			this.status ="Disponível";
		}
		this.status = "Ocupada";
	}
	
	public Turma getTurma() {
		return turma;
	}
	//Ao definir a turma, altera o status da sala
	public void setTurma(Turma turma) {
		this.turma = turma;
		setStatus();
	}
}
