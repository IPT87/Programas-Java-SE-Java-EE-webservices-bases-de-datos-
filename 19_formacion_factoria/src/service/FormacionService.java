package service;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	void altaAlumno(Alumno alumno);

	void altaCurso(Curso curso);

	Alumno buscarPorUsuario(String usuario);

}