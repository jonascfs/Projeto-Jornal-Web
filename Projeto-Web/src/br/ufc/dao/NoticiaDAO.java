package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;
@Repository
public class NoticiaDAO implements INoticiaDAO{
	@PersistenceContext
	private EntityManager manager;
	@Override
	public void adicionarNoticia(Noticia noticia) {	
		manager.persist(noticia);		
	}

	@Override
	public void removerNoticia(Noticia noticia) {
		Noticia n = manager.find(Noticia.class, noticia.getIdNoticia());		
		manager.remove(n);		
	}

	@Override
	public void atualizarNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Noticia> listarNoticia() {
		return manager.createQuery("from Noticia", Noticia.class).getResultList();
	}

	@Override
	public Noticia getNoticia(long id) {
		return manager.find(Noticia.class,id);
	}
	
	
}
