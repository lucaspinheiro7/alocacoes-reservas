package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fametro.model.entity.SalaAula;

@Repository
public class SalaAulaDAO {
	
	// Injeção de dependência do Entity Manager
		@PersistenceContext
		EntityManager em;
		 
		@Transactional
		public void salvar(SalaAula sala){
			em.merge(sala);
		}
		
		@Transactional
		@SuppressWarnings("unchecked")
		public List<SalaAula> buscarTodos(){
			Query consulta = em.createQuery("SELECT s FROM SalaAula s");
			return consulta.getResultList();
		}	
		
		@Transactional
		public SalaAula buscarPorId(long id){
			return em.find(SalaAula.class, id);
		}
}
