package br.ufc.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "secoes")
public class Secao {
	@Id
	@Column(name = "id_secao")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long idSecao;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String descricao;	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secao",targetEntity = Noticia.class , cascade = CascadeType.MERGE)
	Collection<Noticia> noticias;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getIdSecao() {
		return idSecao;
	}
	public void setIdSecao(long idSecao) {
		this.idSecao = idSecao;
	}
	public Collection<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	
}
