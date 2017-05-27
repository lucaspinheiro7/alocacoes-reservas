package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fametro.model.entity.Curso;

@Repository
public class CursoDAO {
	
	// Injeção de dependência do Entity Manager
	@PersistenceContext
	EntityManager em;
	 
	@Transactional
	public void salvar(Curso curso){
		em.merge(curso);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Curso> buscarTodos(){
		Query consulta = em.createQuery("SELECT c FROM Curso c");
		return consulta.getResultList();
	}	
	
	@Transactional
	public Curso buscarPorId(long id){
		return em.find(Curso.class, id);
	}
}
