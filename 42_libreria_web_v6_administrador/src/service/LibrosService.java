package service;

import java.util.List;

import model.Libro;

public interface LibrosService {

	List<Libro> recuperarLibros();

	List<Libro> recuperarLibros(int idTema);
	
	Libro recuperarLibroPorIsbn(int isbn);
}