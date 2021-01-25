package service;

import java.util.List;

import model.Registro;

public interface ContagiosService {
	
	List<Registro> registrosPorPais(String pais);
	List<Registro> registrosEntreFechas(String fechaInicio, String fechaFin);
	void nuevoRegistro(Registro registro);
	
}
