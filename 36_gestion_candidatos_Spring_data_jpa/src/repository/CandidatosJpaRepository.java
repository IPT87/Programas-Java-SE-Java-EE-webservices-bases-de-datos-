package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Candidato;


public interface CandidatosJpaRepository extends JpaRepository<Candidato, Integer> {
	
	Candidato findByEmail(String email);
	
	//@Query(name = "Candidato.buscarEdadMayor")
	@Query("SELECT c FROM Candidato c WHERE c.edad >= ?1")
	List<Candidato> findByEdadMayor(int edad);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Candidato c WHERE c.email = ?1")
	void deleteCandidato(String email);
	
}
