package service;

import java.util.List;
import java.util.stream.Collectors;

import adaptador.AdaptadorLibroEntrada;
import model.Entrada;

public class EntradasServiceImpl implements EntradasService {

	@Override
	public List<Entrada> getEntradas() {
		
		return LibreriaFactory
				.getLibrosService()
				.getLibros()
				.stream()
				.map(l -> new AdaptadorLibroEntrada(l))
				.collect(Collectors.toList());
	}

	@Override
	public List<Entrada> getEntradasTema(String tema) {
		
		return getEntradas()
				.stream()
				.filter(e -> e.getTema().equals(tema))
				.collect(Collectors.toList());
	}

	@Override
	public List<Entrada> getEntradasParteTitulo(String titulo) {
		
		return getEntradas()
				.stream()
				.filter(e -> e.getTitulo().contains(titulo))
				.collect(Collectors.toList());
	}

	@Override
	public double facturacionPorTema(String tema) {
		
		return getEntradasTema(tema)
				.stream()
				.mapToDouble(e -> e.getFacturacion())
				.sum();
	}

}
