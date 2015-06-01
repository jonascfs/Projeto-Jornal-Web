package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name  = "classificados")
public class Classificado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_classificado")
	private long idClassificado;
	@Column(name = "titulo_classificado",nullable = false)
	private String titulo;
	@Column(name = "texto_classificado", nullable = false)
	private String texto;
	@Column(nullable = false)
	private double preco;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false)
	private double melhorOferta;
	@Column(nullable = false, name = "data_oferta")
	private Date dataOferta;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_autor_oferta" , referencedColumnName = "id_usuario")
	private Usuario autorOferta;
	
	public long getIdClassificado() {
		return idClassificado;
	}
	public void setIdClassificado(long idClassificado) {
		this.idClassificado = idClassificado;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public double getMelhorOferta() {
		return melhorOferta;
	}
	public void setMelhorOferta(double melhorOferta) {
		this.melhorOferta = melhorOferta;
	}
	public Date getDataOferta() {
		return dataOferta;
	}
	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}
	public Usuario getAutorOferta() {
		return autorOferta;
	}
	public void setAutorOferta(Usuario autorOferta) {
		this.autorOferta = autorOferta;
	}	
}
