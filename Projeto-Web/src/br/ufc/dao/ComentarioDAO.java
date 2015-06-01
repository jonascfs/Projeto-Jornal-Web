package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;
@Repository
public class ComentarioDAO implements IComentarioDAO{
	@PersistenceContext
	private EntityManager manager;
	@Override
	public void adicionarComentario(Comentario comentario) {		
		manager.persist(comentario);		
	}

	@Override
	public void removerComentario(Comentario comentario) {
		//Tentando outra abordagem		
		manager.remove(comentario);		
	}

	@Override
	public void atualizarComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comentario> listarComenarios() {
		String sql = "from Comentario";
		List<Comentario> comentarios = manager.createQuery(sql,Comentario.class).getResultList();
		return comentarios;
	}

	@Override
	public Comentario getComentario(long id) {
		Comentario comment = manager.find(Comentario.class, id);
		return comment;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
}
