package br.ufc.dao;
import java.util.List;

import br.ufc.model.Role;
public interface IRoleDAO {
	List<Role> getRoles();
	void adicionarRole(Role role);
	void removerRole(Role role);
	void atualizarRole(Role role);
	Role getRole(long id);
}
