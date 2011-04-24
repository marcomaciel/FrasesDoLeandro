package br.com.mmaciel.frasesdoleandro.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
*
* @author Marco Antonio Maciel
* 
*/
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Frase implements Serializable  {
	
	private static final long serialVersionUID = -2612185754087503898L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	@Persistent
	//com.google.appengine.api.datastore.Text
	private String texto;
	
	@Persistent
	private Date data;
	
	@Persistent
	private String autor;
	
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
		return "Frase [id=" + id + ", texto=" + texto + ", data=" + data + ", autor=" + autor
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
