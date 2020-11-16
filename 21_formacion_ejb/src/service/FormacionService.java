package service;

import javax.ejb.Local;

import model.Alumno;
import model.Curso;

@Local
public interface FormacionService {

	void altaAlumno(Alumno alumno);

	void altaCurso(Curso curso);

	Alumno buscarPorUsuario(String usuario);

}