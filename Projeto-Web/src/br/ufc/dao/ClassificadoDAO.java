package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;
@Repository
public class ClassificadoDAO implements IClassificadoDAO{
	@PersistenceContext
	private EntityManager manager;
	@Override
	public void adicionarClassificado(Classificado classificado) {		
		manager.persist(classificado);		
	}

	@Override
	public void removerClassificado(Classificado classificado) {
		Classificado c = manager.find(Classificado.class, classificado.getIdClassificado());		
		manager.remove(c);		
	}

	@Override
	public void atualizarClassificado(Classificado classificado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Classificado> listarClassificados() {
		return manager.createQuery("from Classificado", Classificado.class).getResultList();
	}

	@Override
	public Classificado getClassificado(long id) {
		return manager.find(Classificado.class, id);
	}

}
