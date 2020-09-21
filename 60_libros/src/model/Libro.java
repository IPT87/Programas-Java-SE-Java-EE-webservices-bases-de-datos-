package model;

public class Libro {
	
	private int isbn;
	private String nombre;
	private double precio;
	private String autor;
	private int idTema;
	private int paginas;
	
	
	public Libro(int isbn, String nombre, double precio, String autor, int idTema, int paginas) {
		super();
		this.isbn = isbn;
		this.nombre = nombre;
		this.precio = precio;
		this.autor = autor;
		this.idTema = idTema;
		this.paginas = paginas;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
}
