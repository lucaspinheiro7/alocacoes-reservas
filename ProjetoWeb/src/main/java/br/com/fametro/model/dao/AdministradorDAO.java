package br.com.fametro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fametro.model.entity.Administrador;
import br.com.fametro.model.util.JPAUtil;

public class AdministradorDAO {
	
	EntityManager em;
	
	public AdministradorDAO(){
		em = JPAUtil.abreConexao();
	}
	
	public void salvar(Administrador administrador){
		em.getTransaction().begin();
		em.merge(administrador);
		em.getTransaction().commit();
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
