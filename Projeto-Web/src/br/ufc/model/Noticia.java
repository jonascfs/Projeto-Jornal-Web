package br.ufc.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name  =  "noticias")
public class Noticia {
	@Id
	@Column(name = "id_noticia")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNoticia;
	@Column(nullable = false)	
	private String titulo;
	@Column(nullable = false)
	private String subTitulo;
	@Column(nullable = false)
	private String texto;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNoticia;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_autor" , referencedColumnName = "id_usuario")
	private Usuario autor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_secao" , referencedColumnName = "id_secao")
	private Secao secao;
	
	@OneToMany(mappedBy = "noticia", targetEntity = Comentario.class , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	Collection<Comentario> comentarios;
	
	public Collection<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public long getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(long idNoticia) {
		this.idNoticia = idNoticia;
	}
	public Secao getSecao() {
		return secao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubTitulo() {
		return subTitulo;
	}
	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public Date getDataNoticia() {
		return dataNoticia;
	}
	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}
	public void setSecao(Secao secao) {
		this.secao = secao;
	}
}
