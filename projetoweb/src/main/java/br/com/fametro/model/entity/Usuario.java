package br.com.fametro.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class Usuario {
	
	@Id
	@SequenceGenerator(name="seq_usuario", initialValue=1)
	@GeneratedValue(generator="seq_usuario", strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	private String email;
	private String senha;

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
