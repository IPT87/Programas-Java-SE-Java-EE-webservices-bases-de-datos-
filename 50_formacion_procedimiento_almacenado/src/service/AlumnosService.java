package service;

import java.util.List;

import model.Alumno;

public interface AlumnosService {

	void altaAlumno(Alumno alumno);

	Alumno buscarAlumnoPorUsuario(String usuario);
	List<Alumno> alumnosCurso(int idCurso);
	List<Alumno> alumnos();
	
}