package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Candidato;
import repository.CandidatosJpaRepository;

@Service
public class CandidatosServiceImpl implements CandidatosService {
	@Autowired
	CandidatosJpaRepository repository;
	
	@Override
	public void altaCandidato(Candidato candidato) {
		repository.save(candidato);
	}
	
	@Override
	public void eliminarCandidato(int idCandidato) {
		Candidato candidato = repository.findById(idCandidato).orElse(null);
		if(candidato != null) {
			repository.deleteById(idCandidato);
		}
	}
	
	@Override
	public List<Candidato> recuperarCandidatos() {
		return repository.findAll();
	}

	@Override
	public Candidato buscarCandidatoEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public List<Candidato> buscarCandidatosMayoresEdad(int edad) {
		return repository.findByEdadMayor(edad);
	}

	@Override
	public void eliminarCandidatoEmail(String email) {
		repository.deleteCandidato(email);
	}
}
