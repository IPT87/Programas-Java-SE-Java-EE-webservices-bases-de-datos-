package service;

import java.util.List;

import model.ItemAlumno;
import model.ItemCurso;

public interface ClienteService {
	List<ItemCurso> cursos();
	List<ItemAlumno> alumnosCurso(int codigo);
}
