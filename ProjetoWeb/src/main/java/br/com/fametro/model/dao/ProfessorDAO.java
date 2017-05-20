package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fametro.model.entity.Professor;
import br.com.fametro.model.util.JPAUtil;

public class ProfessorDAO {
	
	EntityManager em;
	
	public ProfessorDAO(){
		em = JPAUtil.abreConexao();
	}
	
	public void salvar(Professor professor){
		em.getTransaction().begin();
		em.merge(professor);
		em.getTransaction().commit();
	}
	
	public void excluir(Professor professor){
		em.getTransaction().begin();
		em.remove(professor);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> buscarTodos(){
		Query consulta = em.createQuery("select p from Professor p"); // JPQL
		return consulta.getResultList();
	}
	
	public Professor buscarPorId(long id){
		return em.find(Professor.class, id);
	}
}
