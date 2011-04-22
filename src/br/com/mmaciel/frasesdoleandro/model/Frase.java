package br.com.mmaciel.frasesdoleandro.model;

import java.util.Date;

/**
*
* @author Marco Antonio Maciel
* 
*/
public class Frase {
	
	public Frase() {
	}
	
	public Frase(String texto, Date data, String autor) {
		super();
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}
	
	public Frase(String texto) {
		this.texto = texto;
	}

	private String texto;
	private Date data;
	private String autor;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Frase [texto=" + texto + ", data=" + data + ", autor=" + autor
				+ "]";
	}
	
}
