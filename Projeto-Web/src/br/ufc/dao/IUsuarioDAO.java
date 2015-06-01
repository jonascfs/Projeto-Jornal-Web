package br.ufc.dao;

import java.util.List;

import br.ufc.model.Usuario;

public interface IUsuarioDAO {
	void adicionarUsuario(Usuario usuario);
	void removerUsuario(Usuario usuario);
	void atualizarUsuario(Usuario usuario);
	Usuario getUsuario(long id);
	Usuario getUsuario(String login);
	List<Usuario> listarUsuarios();
	
}
