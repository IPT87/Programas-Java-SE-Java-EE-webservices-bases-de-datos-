package service;

import java.util.List;

import model.Candidato;
import model.Inscripcion;

public interface InscripcionesService {
	
	void registrarInscripcion(Inscripcion inscripcion);
	
	List<Inscripcion> obtenerInscripciones();
	
	List<String> obtenerEmpresas();
	
	List<Inscripcion> obtenerCandidatosPorEmpresa(String nombreEmpresa);
}
