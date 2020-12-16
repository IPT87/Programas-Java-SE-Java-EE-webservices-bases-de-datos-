package service;

import java.util.List;

import model.Inscripcion;

public interface InscripcionesService {
	void registrarInscripcion(Inscripcion inscripcion);
	List<Inscripcion> obtenerInscripciones();
	List<String> obtenerEmpresas();
	List<Inscripcion> obtenerInscripcionesEmpresa(String empresa);
}
