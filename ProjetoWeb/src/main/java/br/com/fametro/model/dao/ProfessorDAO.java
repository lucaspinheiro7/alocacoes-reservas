package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fametro.model.entity.Professor;

@Repository
public class ProfessorDAO {
	
	// Injeção de dependência do Entity Manager
	@PersistenceContext
	EntityManager em;
	 
	@Transactional
	public void salvar(Professor professor){
		em.merge(professor);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Professor> buscarTodos(){
		Query consulta = em.createQuery("SELECT p FROM Professor p");
		return consulta.getResultList();
	}	
	
	@Transactional
	public Professor buscarPorId(long id){
		return em.find(Professor.class, id);
	}
}
