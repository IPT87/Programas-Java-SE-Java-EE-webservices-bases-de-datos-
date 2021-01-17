package model;

import javax.xml.bind.annotation.XmlRootElement;

// Si quieremos que la respuesta sea en XML
// @XmlRootElement
public class Libro {
	
	private String titulo;
	private int isbn;
	private String tematica;
	
	public Libro() {
		super();
	}
	
	public Libro(int isbn, String titulo, String tematica) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.tematica = tematica;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	
}
