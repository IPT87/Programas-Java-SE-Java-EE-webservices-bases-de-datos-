package service;

import java.util.List;

import javax.ejb.Local;

import model.Alumno;
import model.Curso;

@Local
public interface FormacionService {

	void altaAlumno(Alumno alumno);

	void altaCurso(Curso curso);

	Alumno buscarPorUsuario(String usuario);
	
	List<Alumno> buscarPorNota(double nota);
	
	List<Alumno> buscarPorCurso(String curso);
	
	List<Curso> buscarPorAlumno(String user);
	
	List<Alumno> alumnos();

}