package service.port;

import java.util.List;

import model.Candidato;

public interface CandidatosService {
	
	void guardarCandidato(Candidato candidato);
	
	void eliminarCandidato(int codigoCandidato);
	
	List<Candidato> obtenerCandidatos();
	
}
