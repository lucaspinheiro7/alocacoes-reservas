package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fametro.model.entity.Administrador;

@Repository
public class AdministradorDAO {
	
	// Injeção de dependência do Entity Manager
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void salvar(Administrador administrador){
		em.merge(administrador);
	}
	
	public void excluir(Administrador administrador){
		em.getTransaction().begin();
		em.remove(administrador);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Administrador> buscarTodos(){
		Query consulta = em.createQuery("select a from Administrador a"); // JPQL
		return consulta.getResultList();
	}
	
	public Administrador buscarPorId(long id){
		return em.find(Administrador.class, id);
	}
}
