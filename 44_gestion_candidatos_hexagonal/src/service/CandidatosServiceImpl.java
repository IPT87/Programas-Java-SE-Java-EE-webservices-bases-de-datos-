package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Candidato;
import repository.port.CandidatosRepository;
import service.port.CandidatosService;

@Service
public class CandidatosServiceImpl implements CandidatosService {
	@Autowired
	CandidatosRepository repository;
	
	@Override
	public void guardarCandidato(Candidato candidato) {
		if (repository.findByEmail(candidato.getEmail()) == null) {
			repository.saveCandidato(candidato);
		}
	}

	@Override
	public void eliminarCandidato(int codigoCandidato) {
		if (repository.findByCodigo(codigoCandidato) != null) {
			repository.deleteCandidatoByCodigo(codigoCandidato);
		}
	}

	@Override
	public List<Candidato> obtenerCandidatos() {
		return repository.findAll();
	}

}
