package model;

public class Libro {
	
	private int isbn;
	private String autor;
	private String titulo;
	private String tematica;
	
	
	public Libro(int isbn, String titulo, String tematica) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.tematica = tematica;
	}
	
	public Libro(String autor, String titulo, int isbn) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.isbn = isbn;
	}
	
	public Libro() {
		super();
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTematica() {
		return tematica;
	}
	
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	@Override
	public String toString() {
		return "Titulo: " + getTitulo() + ", tematica: " + getTematica() + ", isbn: " + getIsbn();
	}
	
	
}
