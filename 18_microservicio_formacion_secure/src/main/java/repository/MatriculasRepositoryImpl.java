package repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Curso;

@Repository
public class MatriculasRepositoryImpl implements MatriculasRepository {
	@Autowired
	MatriculasJpaRepository repository;
	
	@Override
	public List<Curso> matriculasRangoFecha(Date fechaInicio, Date fechaFin) {
		return repository.findByFechaInicioBetween(fechaInicio, fechaFin);
	}

}
