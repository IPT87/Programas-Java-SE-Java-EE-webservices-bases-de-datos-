package repository;

import java.util.List;

import model.Libro;

public interface LibrosRepository {
	
	List<Libro> todosLibros();
	List<Libro> librosPorTematica(String tematica);
	Libro libroIsbn(int isbn);
	void nuevoLibro(Libro libro);
	void actualizarLibro(Libro libro);
	void eliminarLibro(int isbn);
	
}
