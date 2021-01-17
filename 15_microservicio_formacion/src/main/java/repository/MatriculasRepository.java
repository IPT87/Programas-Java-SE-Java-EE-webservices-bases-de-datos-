package repository;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface MatriculasRepository {
	
	List<Curso> matriculasRangoFecha(Date fechaInicio, Date fechaFin);
	
}
