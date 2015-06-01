package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comentarios")
public class Comentario {
	@Id
	@Column(name = "id_comentario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idComentario;
	
	@Column(name = "texto_comentario",nullable = true)
	private String texto;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario autor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_noticia", referencedColumnName = "id_noticia")
	private Noticia noticia;
	
	public long getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(long idComentario) {
		this.idComentario = idComentario;
	}
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}		
}
