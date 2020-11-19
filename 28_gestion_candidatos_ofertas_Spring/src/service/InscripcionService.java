package service;

import java.util.List;

import model.Inscripcion;

public interface InscripcionService {
	
	void nuevaInscripcion(Inscripcion inscripcion);
	
	List<Inscripcion> recuperarInscripciones();
	
}
