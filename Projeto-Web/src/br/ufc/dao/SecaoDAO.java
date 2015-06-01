package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;
@Repository
public class SecaoDAO implements ISecaoDAO{
	@PersistenceContext
	private EntityManager manager;
	@Override
	public void adicionarSecao(Secao secao) {	
		manager.persist(secao);		
	}

	@Override
	public void removerSecao(Secao secao) {
		Secao s = manager.find(Secao.class, secao.getIdSecao());		
		manager.remove(s);
	}

	@Override
	public void atualizarSecao(Secao secao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Secao> listarSecoes() {
		return manager.createQuery("from Secao", Secao.class).getResultList();
	}

	@Override
	public Secao getSecao(long id) {
		return manager.find(Secao.class, id);
	}
	
}
