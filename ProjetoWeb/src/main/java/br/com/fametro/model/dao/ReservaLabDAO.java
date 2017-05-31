package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fametro.model.entity.ReservaLab;

@Repository
public class ReservaLabDAO {

	// Injeção de dependência do Entity Manager
	@PersistenceContext
	EntityManager em;
	 
	@Transactional
	public void salvar(ReservaLab reservaLab){
		em.merge(reservaLab);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ReservaLab> buscarTodos(){
		Query consulta = em.createQuery("SELECT r FROM ReservaLab r");
		return consulta.getResultList();
	}	
	
}
