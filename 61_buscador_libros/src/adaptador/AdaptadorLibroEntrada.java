package adaptador;

import model.Entrada;
import model.Libro;
import service.LibreriaFactory;

public class AdaptadorLibroEntrada implements Entrada {
	
	private Libro libro;
	
	public AdaptadorLibroEntrada(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String getTitulo() {
		
		return libro.getNombre();
	}

	@Override
	public String getAutor() {
		
		return libro.getAutor();
	}

	@Override
	public String getTema() {
		
		return LibreriaFactory.getLibrosService().getTema(libro.getIdTema());
	}

	@Override
	public double getFacturacion() {
		
		return LibreriaFactory.getLibrosService().getFacturacion(libro.getIsbn());
	}
	
	@Override
	public String toString() {
		
		return "Titulo: " + getTitulo() + ", tema: " + getTema() + ", autor: " + getAutor() + ", precio: " + libro.getPrecio() + ".";
	}

}
