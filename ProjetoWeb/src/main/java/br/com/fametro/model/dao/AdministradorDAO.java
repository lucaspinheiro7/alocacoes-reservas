package br.com.fametro.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
