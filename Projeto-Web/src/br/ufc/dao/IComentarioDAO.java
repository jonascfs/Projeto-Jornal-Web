package br.ufc.dao;

import java.util.List;

import br.ufc.model.Comentario;

public interface IComentarioDAO {
	void adicionarComentario(Comentario comentario);
	void removerComentario(Comentario comentario);
	void atualizarComentario(Comentario comentario);
	List<Comentario> listarComenarios();
	Comentario getComentario(long id);
}
