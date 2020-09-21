package service;

import java.util.List;

import model.Libro;

public interface LibrosService {
	
	public List<Libro> getLibros();
	
	public String getTema(int idTema);
	
	public double getFacturacion(int isbn);
}
