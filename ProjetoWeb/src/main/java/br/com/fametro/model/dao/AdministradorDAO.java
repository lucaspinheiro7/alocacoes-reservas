package br.com.fametro.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fametro.model.entity.Administrador;
import br.com.fametro.model.util.JPAUtil;

@Repository
public class AdministradorDAO {
	
	// Injeção de dependência do Entity Manager
	@PersistenceContext
	EntityManager em;
	
	public AdministradorDAO(){
		em = JPAUtil.abreConexao();
	}
	 
	@Transactional
	public void salvar(Administrador administrador){
		em.merge(administrador);
	}
}
