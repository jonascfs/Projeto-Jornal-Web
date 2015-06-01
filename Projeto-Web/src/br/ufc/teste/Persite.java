package br.ufc.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.dao.RoleDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Usuario;
import br.ufc.model.Role;
		
public class Persite {
	public static void main(String[] args) {
		UsuarioDAO uDao = new UsuarioDAO();
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("jornal");
		EntityManager manager = factory.createEntityManager();
		RoleDAO roleDAO = new RoleDAO();
		uDao.setManager(manager);
		
		roleDAO.setManager(manager);
		List<Role>  roles = roleDAO.getRoles();
		System.out.println(roles);
		uDao.setManager(manager);
		Usuario u = uDao.getUsuario(1l);
//		Usuario u = new Usuario();
//		u.setNome("Fulano");
//		u.setEmail("fulano@sicrano.com");
//		u.setLogin("fulaniho");
//		u.setSenha("4444");
//		u.setRoles(roles);
		uDao.removerUsuario(u);
		manager.close();
		factory.close();
	}
}
