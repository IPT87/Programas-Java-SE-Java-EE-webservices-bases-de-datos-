package repository.adapter.jpa;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Candidato;
import repository.adapter.entity.CandidatoEntity;
import repository.adapter.entity.Utilidades;
import repository.port.CandidatosRepository;

@Repository
public class CandidatosRepositoryJpaImpl implements CandidatosRepository {
	@PersistenceContext(unitName = "empresaPU")
	EntityManager em;
	
	@Transactional
	@Override
	public void saveCandidato(Candidato candidato) {
		// transformamos el objeto Candidato en una entidad para hacer la persistencia
		em.persist(Utilidades.candidatoEntityBuilder(candidato));
	}

	@Transactional
	@Override
	public void deleteCandidatoByCodigo(int codigo) {
		CandidatoEntity entity = em.find(CandidatoEntity.class, codigo);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public List<Candidato> findAll() {
		TypedQuery<CandidatoEntity> query = em.createNamedQuery("CandidatoEntity.findAll", CandidatoEntity.class);
		List<CandidatoEntity> entidades = query.getResultList();
		
		return entidades
					.stream()
					.map(entity -> Utilidades.candidatoBuilder(entity))
					.collect(Collectors.toList());
	}

	@Override
	public Candidato findByCodigo(int codigo) {
		CandidatoEntity entity = em.find(CandidatoEntity.class, codigo);
		if (entity != null) {
			return Utilidades.candidatoBuilder(entity);
		} else {
			return null;
		}
	}

	@Override
	public Candidato findByEmail(String email) {
		String jpql = "SELECT c FROM CandidatoEntity c WHERE c.email = ?1";
		TypedQuery<CandidatoEntity> query = em.createQuery(jpql, CandidatoEntity.class);
		query.setParameter(1, email);
		List<CandidatoEntity> entities = query.getResultList();
		
		return entities.size() > 0 ? Utilidades.candidatoBuilder(entities.get(0)) : null;
	}

}
