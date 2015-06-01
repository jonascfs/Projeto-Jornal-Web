package br.ufc.dao;

import java.util.List;

import br.ufc.model.Secao;

public interface ISecaoDAO {
	void adicionarSecao(Secao secao);
	void removerSecao(Secao secao);
	void atualizarSecao(Secao secao);
	List<Secao> listarSecoes();
	Secao getSecao(long id);
}
