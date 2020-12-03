package repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;
@Repository("cursosJpaEstandar")
public class CursosRepositoryImpl implements CursosRepository {
	@PersistenceContext(unitName = "formacionPU")
	EntityManager em;
	@Transactional()
	@Override
	public void altaCurso(Curso curso) {
		em.persist(curso);
		
	}

	@Override
	public Curso cursoPorId(int idCurso) {
		return em.find(Curso.class, idCurso);
	}

	@Override
	public List<Curso> todosCursos() {
		TypedQuery<Curso> query=em.createNamedQuery("Curso.findAll",Curso.class);
		return query.getResultList();
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		String jpql="Select c From Curso c join c.alumnos a where a.usuario=?1";
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		query.setParameter(1, usuario);
		return query.getResultList();
	}

	@Override
	public List<Curso> cursosDisponiblesAlumno(String usuario) {
		String jpql="select c from Curso c where c not in ";
		jpql+="(select c from Curso c join c.alumnos a where a.usuario=?1)";
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		query.setParameter(1, usuario);		
		return query.getResultList();
	}

	@Override
	public List<Curso> cursosEntreFechas(Date f1, Date f2) {
		String jpql="select distinct c from Curso c join fetch c.alumnos where c.fechaInicio>=?1 and c.fechaInicio<=?2";
		//String jpql="select c from Curso c where c.fechaInicio> between ?1 and ?2";
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		query.setParameter(1, f1,TemporalType.DATE);
		query.setParameter(2, f2,TemporalType.DATE);
		
		return query.getResultList();
	}

}
