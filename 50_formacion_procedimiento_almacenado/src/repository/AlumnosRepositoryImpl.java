package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Repository("alumnosJpaEstandar")
public class AlumnosRepositoryImpl implements AlumnosRepository {
	@PersistenceContext(unitName = "formacionPU")
	EntityManager em;
	@Transactional
	@Override
	public void guardarAlumno(Alumno alumno) {
		em.persist(alumno);
	}

	@Override
	public Alumno buscarAlumnoPorUsuario(String usuario) {
		//return em.find(Alumno.class, usuario);
		//quiero utilizar join fetch, para que al traer el alumno
		//se traiga sus cursos y evitar la propiedad de hibernate que fuerza 
		//accesos adicionales a la BD
		String jpql="select a from Alumno a join fetch a.cursos where a.usuario=?1";
		TypedQuery<Alumno> query=em.createQuery(jpql,Alumno.class);
		query.setParameter(1, usuario);
		List<Alumno> alumnos=query.getResultList();
		return alumnos.size()>0?alumnos.get(0):null;
		
	}
	@Transactional
	@Override
	public void actualizarAlumno(Alumno alumno) {
		em.merge(alumno);
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		String jpql="Select a From Alumno a join a.cursos c where c.idCurso=?1";
		TypedQuery<Alumno> query=em.createQuery(jpql,Alumno.class);
		query.setParameter(1, idCurso);
		return query.getResultList();
	}

	@Override
	public List<Alumno> todosAlumnos() {
		TypedQuery<Alumno> query=em.createNamedQuery("Alumno.findAll",Alumno.class);
		return query.getResultList();
	}

	@Override
	public int totalCursosAlumno(String usuario) {
		StoredProcedureQuery query=em.createStoredProcedureQuery("contarCursosAlumno");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
		query.setParameter(1, usuario);
		query.execute();
		return (Integer)query.getOutputParameterValue(2);
	}

}
