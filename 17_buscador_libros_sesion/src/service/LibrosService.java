package service;

import java.util.List;

import model.Libro;

public interface LibrosService {
	List<Libro> buscarPorTematica(String tematica);
	Libro buscarLibro(int isbn);
	void eliminarLibro(int isbn);
}
