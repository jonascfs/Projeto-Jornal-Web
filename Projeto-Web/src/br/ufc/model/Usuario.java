package br.ufc.model;

import java.util.Collection;
import java.util.List;

import br.ufc.model.Role;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@Column(nullable = false, name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long usuarioId;
	@Column(nullable = false)	
	private String nome;
	@Column(nullable = false, unique = true)
	private String login;
	@Column(nullable = false)	
	private String senha;
	@Column(nullable = false )
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_role", 
		joinColumns = @JoinColumn(name = "id_usuario" ,referencedColumnName = "id_usuario" ), 
		inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id_role" ) )
	private List<Role> roles;
	
	@OneToMany(mappedBy = "autor",targetEntity = Noticia.class,fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	Collection<Noticia> noticias;
	
	@OneToMany(mappedBy = "autor", targetEntity = Comentario.class,fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	Collection<Comentario> comentarios;
	
	@OneToMany(mappedBy = "autorOferta" , targetEntity = Classificado.class, fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	Collection<Classificado> classificados;
	
	public long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean is(String role){
		for (Role r : roles) {
			if(r.getRoleName().equals(role))
				return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return this.nome;
	}
	
	
}
