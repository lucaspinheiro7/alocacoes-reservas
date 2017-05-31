package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fametro.model.entity.Turma;


@Repository
public class TurmaDAO {
	
	// Injeção de dependência do Entity Manager
	@PersistenceContext
	EntityManager em;
	 
	@Transactional
	public void salvar(Turma turma){
		em.merge(turma);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Turma> buscarTodos(){
		Query consulta = em.createQuery("SELECT t FROM Turma t");
		return consulta.getResultList();
	}
}
