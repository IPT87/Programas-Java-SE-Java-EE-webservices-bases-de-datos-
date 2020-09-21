package service;

import java.util.List;

import model.Entrada;

public interface EntradasService {
	
	List<Entrada> getEntradas();
	
	List<Entrada> getEntradasTema(String tema);
	
	List<Entrada> getEntradasParteTitulo(String titulo);
	
	double facturacionPorTema(String tema);
}
