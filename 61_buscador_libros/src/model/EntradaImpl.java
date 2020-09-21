package model;

public class EntradaImpl implements Entrada {
	private String titulo;
	private String autor;
	private String tema;
	private double facturacion;


	public EntradaImpl(String titulo, String autor, String tema, double facturacion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.tema = tema;
		this.facturacion = facturacion;
	}

	@Override
	public String getTitulo() {

		return titulo;
	}

	@Override
	public String getAutor() {
		
		return autor;
	}

	@Override
	public String getTema() {
		
		return tema;
	}

	@Override
	public double getFacturacion() {
		
		return facturacion;
	}

}
