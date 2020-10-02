package service;

import java.util.List;

import model.Libro;

public interface TemaService {
	
	List<String> getTema();
	
	List<Libro> getLibros(String tema);
}
