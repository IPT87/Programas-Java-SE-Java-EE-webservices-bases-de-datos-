package service;

import java.util.List;

import model.Tema;

public interface TemasService {

	List<Tema> obtenerTemas();
	
	Tema recuperarTemaPorId(int idTema);
}