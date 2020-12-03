package service;

import java.util.List;

import model.Curso;

public interface MatriculasService {
	void matricularAlumno(String usuario,int idCurso);
	List<Curso> consultarMatriculas(String f1, String f2);
}
