package service;

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
	
}
