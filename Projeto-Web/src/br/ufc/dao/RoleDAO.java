package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Role;
@Repository
public class RoleDAO implements IRoleDAO{
	@PersistenceContext
	private EntityManager manager;
	@Override
	public List<Role> getRoles() {
		String sql = "from Role";
		List<Role> roles = manager.createQuery(sql,Role.class).getResultList();
		return roles;
	}
	public Role getRole(long id){
		return (Role) manager.find(Role.class, id);
	}
	
	@Override
	public void adicionarRole(Role role) {		
		manager.persist(role);		
		
	}
	@Override
	public void removerRole(Role role) {
		Role r = manager.find(Role.class, role.getIdRole());		
		manager.remove(r);		
	}
	@Override
	public void atualizarRole(Role role) {
		
	}
	
	public EntityManager getManager() {
		return manager;
	}
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
}
