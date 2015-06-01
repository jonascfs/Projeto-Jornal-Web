package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;
@Repository
public class UsuarioDAO implements IUsuarioDAO{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void adicionarUsuario(Usuario usuario) {
		manager.persist(usuario);
	}

	@Override
	public void removerUsuario(Usuario usuario) {
		Usuario u = manager.find(Usuario.class, usuario.getUsuarioId());
		manager.remove(u);
	}

	@Override
	public void atualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getUsuario(long id) {
		Usuario u = manager.find(Usuario.class, id);
		return u;
	}

	@Override
	public List<Usuario> listarUsuarios() {
		String sql = "FROM Usuario";
		return manager.createQuery(sql, Usuario.class).getResultList();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Usuario getUsuario(String login) {
		String sql = "select u from Usuario as u where u.login = :u_login";
		TypedQuery<Usuario> query = manager.createQuery(sql,Usuario.class);
		List<Usuario> user = query.setParameter("u_login", login).getResultList();
		if(user.size() == 0)
			return null;
		else
			return user.get(0);
		
		
	}
	
	

}
