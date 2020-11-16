package service;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import model.Curso;
import model.Pregunta;

/**
 * Session Bean implementation class CursosServiceImpl
 */
@Stateless
@LocalBean
public class CursosServiceImpl implements CursosService {
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CursosServiceImpl() {
        
    }

	@Override
	public List<Pregunta> preguntasCurso(String curso) {
		/*String jpql = "SELECT c FROM Curso WHERE c.nombre=?1";
		TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
		query.setParameter(1, curso);
		List<Curso> cursos = query.getResultList();
		
		if (cursos.size() > 0) {
			Curso cr = cursos.get(0);
			return cr.getPreguntas();
		}
		return null;*/
		
		// solucion con join implicito de lado muchos
		String jpql = "SELECT p FROM Pregunta WHERE p.curso.nombre=?1";
		TypedQuery<Pregunta> query = em.createQuery(jpql, Pregunta.class);
		query.setParameter(1, curso);
		return query.getResultList();
	}

	@Override
	public List<Pregunta> preguntaCursoDuracion(Date fechaInicio) {
		String jpql = "SELECT p FROM Pregunta WHERE p.curso.fechainicio > ?1";
		TypedQuery<Pregunta> query = em.createQuery(jpql, Pregunta.class);
		query.setParameter(1, fechaInicio, TemporalType.DATE);
		return query.getResultList();
	}

	@Override
	public List<Curso> cursosPorPregunta(String texto) {
		// solucion con join explicito de lado uno
		String jpql = "SELECT c FROM Curso c JOIN c.preguntas p WHERE p.enunciado LIKE ?1";
		TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
		query.setParameter(1, "%" + texto + "%");
		return query.getResultList();
	}

}
