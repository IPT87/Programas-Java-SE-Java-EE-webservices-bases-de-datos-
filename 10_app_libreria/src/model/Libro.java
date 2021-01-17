package model;

public class Libro {
	
	private int isbn;

	private String tematica;

	private String titulo;

	public Libro() {
		super();
	}
	
	public Libro(int isbn, String tematica, String titulo) {
		super();
		this.isbn = isbn;
		this.tematica = tematica;
		this.titulo = titulo;
	}

	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTematica() {
		return this.tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
