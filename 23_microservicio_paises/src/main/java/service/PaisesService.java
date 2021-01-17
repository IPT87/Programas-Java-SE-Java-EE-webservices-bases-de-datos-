package service;

import java.util.List;

import model.Pais;

public interface PaisesService {
	List<Pais> paisesPorContinente(String continente);
	List<String> continentes();
	Pais buscarPais(String nombre);
}
