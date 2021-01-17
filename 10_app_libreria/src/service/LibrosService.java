package service;

import java.util.List;

import model.Libro;

public interface LibrosService {
	
	void nuevoLibro(Libro libro);
	List<Libro> librosPorTematica(String tematica);
	void actualizarLibro(Libro libro);
	void eliminarLibro(int isbn);
	Libro libroIsbn(int isbn);
	
}
