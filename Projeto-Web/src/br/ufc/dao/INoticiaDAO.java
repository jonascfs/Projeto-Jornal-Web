package br.ufc.dao;

import java.util.List;

import br.ufc.model.Noticia;

public interface INoticiaDAO {
	void adicionarNoticia(Noticia noticia);
	void removerNoticia(Noticia noticia);
	void atualizarNoticia(Noticia noticia);
	List<Noticia> listarNoticia();
	Noticia getNoticia(long id);
}
