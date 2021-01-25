package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Registro;
import repository.ContagiosMongoRepository;

@Service
public class ContagiosServiceImpl implements ContagiosService {
	@Autowired
	ContagiosMongoRepository repository;

	@Override
	public List<Registro> registrosPorPais(String pais) {
		return repository.findByPais(pais);
	}

	@Override
	public List<Registro> registrosEntreFechas(String fechaInicio, String fechaFin) {
		return repository.registrosEntreFechas(fechaInicio, fechaFin);
	}

	@Override
	public void nuevoRegistro(Registro registro) {
		repository.save(registro);
	}

}
