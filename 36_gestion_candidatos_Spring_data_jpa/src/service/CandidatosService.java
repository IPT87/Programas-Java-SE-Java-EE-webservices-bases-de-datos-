package service;

import java.util.List;

import model.Candidato;

public interface CandidatosService {

	void altaCandidato(Candidato candidato);

	void eliminarCandidato(int idCandidato);

	List<Candidato> recuperarCandidatos();
	
	Candidato buscarCandidatoEmail(String email);
	
	List<Candidato> buscarCandidatosMayoresEdad(int edad);
	
	void eliminarCandidatoEmail(String email);

}