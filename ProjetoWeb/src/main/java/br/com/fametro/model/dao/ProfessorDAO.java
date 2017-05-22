package br.com.fametro.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
