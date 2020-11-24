package repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Curso;

@Repository
public class MatriculasRepositoryImpl implements MatriculasRepository {
	@PersistenceContext(unitName = "formacionPU")
	EntityManager em;
	
	@Override
	public List<Curso> matriculasRangoFecha(Date fechaInicio, Date fechaFin) {
		String jpql = "SELECT c FROM Curso c WHERE c.fechaInicio >= ?1 AND c.fechaInicio <= ?2";
		TypedQuery<Curso> query = em.createQuery(jpql,Curso.class);
		query.setParameter(1, fechaInicio);
		query.setParameter(2, fechaFin);
		return query.getResultList();
	}

}
