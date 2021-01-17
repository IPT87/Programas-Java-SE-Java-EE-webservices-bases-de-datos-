package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	List<Curso> todosCursos();
	List<Alumno> alumnosPorCurso(int idCurso);
}
