package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fametro.model.entity.Laboratorio;

@Repository
public class LaboratorioDAO {
	
	// Injeção de dependência do Entity Manager
	@PersistenceContext
	EntityManager em;
	 
	@Transactional
	public void salvar(Laboratorio laboratorio){
		em.merge(laboratorio);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Laboratorio> buscarTodos(){
		Query consulta = em.createQuery("SELECT l FROM Laboratorio l");
		return consulta.getResultList();
	}	
}
