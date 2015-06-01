package br.ufc.dao;

import java.util.List;

import br.ufc.model.Classificado;

public interface IClassificadoDAO {
	void adicionarClassificado(Classificado classificado);
	void removerClassificado(Classificado classificado);
	void atualizarClassificado(Classificado classificado);
	List<Classificado> listarClassificados();
	Classificado getClassificado(long id);
}
