package br.com.fametro.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.fametro.model.dao.AdministradorDAO;
import br.com.fametro.model.dao.ProfessorDAO;
import br.com.fametro.model.entity.Administrador;
import br.com.fametro.model.entity.Professor;

@Service
public class LoginService {

	@Inject
	private AdministradorDAO adminDAO;

	@Inject
	private ProfessorDAO profDAO;

	public Professor validar(Professor professor) {

		List<Professor> profList = profDAO.buscarTodos();
		Professor profAutenticado = null;

		for (Professor p : profList) {
			if (professor.getEmail().equals(p.getEmail())) {
				// Verifica email passado no campo existe no banco

				if (professor.getSenha().equals(p.getSenha())) {
					// Verifica se a senha passada corresponde ao email encontrado

					profAutenticado = new Professor();
					profAutenticado.setId(p.getId());
					profAutenticado.setNome(p.getNome());
					profAutenticado.setEmail(p.getEmail());
					profAutenticado.setSenha(p.getSenha());
					// Passa os dados do banco para o professor autenticado
					
				}
			}
		}
		return profAutenticado;
	}

	public Administrador validar(Administrador administrador) {

		List<Administrador> adminList = adminDAO.buscarTodos();
		Administrador adminAutenticado = null;

		for (Administrador a : adminList) {
			if (administrador.getEmail().equals(a.getEmail())) {
				// Verifica email passado no campo existe no banco

				if (administrador.getSenha().equals(a.getSenha())) {
					// Verifica se a senha passada corresponde ao email encontrado

					adminAutenticado = new Administrador();
					adminAutenticado.setId(a.getId());
					adminAutenticado.setNome(a.getNome());
					adminAutenticado.setEmail(a.getEmail());
					adminAutenticado.setSenha(a.getSenha());
					// Passa os dados do banco para o administrador autenticado
					
				}
			}
		}
		return adminAutenticado;
	}
	
}
