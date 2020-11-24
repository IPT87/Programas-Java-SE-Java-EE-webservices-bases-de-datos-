package service;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface MatriculasService {
	
	void matricularAlumno(String usuario,int idCurso);
	
	List<Curso> matriculasRangoFecha(Date fechaInicio, Date fechaFin);
	
}
