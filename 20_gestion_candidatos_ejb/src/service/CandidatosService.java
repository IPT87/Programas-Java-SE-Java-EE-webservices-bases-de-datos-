package service;

import java.util.List;

import javax.ejb.Local;

import model.Candidato;

@Local
public interface CandidatosService {

	void eliminarCandidatoPorEmail(String email);

	Candidato buscarPorEmail(String email);

	List<Candidato> recuperarCandidatoPuesto(String puesto);

	List<Candidato> recuperarCandidatos();

	void eliminarCandidato(int idCandidato);

	void altaCandidato(Candidato candidato);

}
