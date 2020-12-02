package repository.port;

import java.util.List;

import model.Candidato;

public interface CandidatosRepository {
	
	void saveCandidato(Candidato candidato);
	
	void deleteCandidatoByCodigo(int codigo);
	
	List<Candidato> findAll();
	
	Candidato findByCodigo(int codigo);
	
	Candidato findByEmail(String email);
	
}
