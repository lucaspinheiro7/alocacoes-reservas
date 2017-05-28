package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fametro.model.entity.ReservaSala;


@Repository
public class ReservaSalaDAO {
	
	// Injeção de dependência do Entity Manager
		@PersistenceContext
		EntityManager em;
		 
		@Transactional
		public void salvar(ReservaSala reservaSala){
			em.merge(reservaSala);
		}
		
		@Transactional
		@SuppressWarnings("unchecked")
		public List<ReservaSala> buscarTodos(){
			Query consulta = em.createQuery("SELECT r FROM ReservaSala r");
			return consulta.getResultList();
		}	
}
