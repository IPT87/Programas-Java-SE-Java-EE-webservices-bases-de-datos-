package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.Curso;
import model.Pregunta;

@Local
public interface CursosService {
	
	List<Pregunta> preguntasCurso(String curso);
	
	List<Pregunta> preguntaCursoDuracion(Date fechaInicio);
	
	List<Curso> cursosPorPregunta (String texto);
}
