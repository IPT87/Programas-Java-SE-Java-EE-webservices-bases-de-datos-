package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	
	void altaAlumno(Alumno alumno);

	void altaCurso(Curso curso);

	Alumno buscarPorUsuario(String usuario);
	
	List<Alumno> buscarPorCurso(String curso);
	
	List<Curso> buscarPorAlumno(String user);
	
	List<Alumno> alumnos();
}
