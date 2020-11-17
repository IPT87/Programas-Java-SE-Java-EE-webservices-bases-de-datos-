package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Alumno;
import model.Curso;

@Stateless
@LocalBean
public class FormacionServiceImpl implements FormacionService {
	@PersistenceContext(unitName = "formacionPU")
	private EntityManager em;
	
	@Override
	public void altaAlumno(Alumno alumno) {
		em.persist(alumno);	
	}
	
	@Override
	public void altaCurso(Curso curso) {
		em.persist(curso);	
	}
	
	@Override
	public Alumno buscarPorUsuario(String usuario) {
		TypedQuery<Alumno> query = em.createNamedQuery("Alumno.findByUsuario", Alumno.class);
		query.setParameter(1, usuario);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}

	@Override
	public List<Alumno> buscarPorNota(double nota) {
		String jpql = "SELECT DISTINCT a FROM Alumno a join a.matriculas m WHERE m.nota >= ?1";
		TypedQuery<Alumno> query = em.createQuery(jpql, Alumno.class);
		query.setParameter(1, nota);
		return query.getResultList();
	}

	@Override
	public List<Alumno> buscarPorCurso(String curso) {
		String jpql = "SELECT a FROM Alumno a JOIN a.matriculas m WHERE m.curso.nombre = ?1";
		TypedQuery<Alumno> query = em.createQuery(jpql, Alumno.class);
		query.setParameter(1, curso);
		return query.getResultList();
	}

	@Override
	public List<Curso> buscarPorAlumno(String user) {
		String jpql = "SELECT c FROM Curso c JOIN c.matriculas m WHERE m.alumno.usuario = ?1";
		TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
		query.setParameter(1, user);
		return query.getResultList();
	}

	@Override
	public List<Alumno> alumnos() {
		TypedQuery<Alumno> query = em.createNamedQuery("Alumno.findAll", Alumno.class);
		return query.getResultList();
	}
	
}
