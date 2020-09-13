package service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Caso;
import util.Utilidades;

public class CasosService {
	private Path path;
	private String fuente;
	private String separador = ",";
	
	
	public CasosService(String fuente) {
		this.fuente = fuente;
		path = Paths.get(fuente);
	}
	
	public List<Caso> getComunidades() {
		return crearStream()
				.map(c -> Utilidades.construirCaso(fuente, separador))
				.collect(Collectors.toList());
	}
	
	public List<Caso> casosPorPeriodo(Date fechaDesde, Date fechaHasta) {
		return crearStream()
						.filter(c -> c.getFecha().after(fechaDesde) && c.getFecha().before(fechaHasta))
						.collect(Collectors.toList());
	} 
	
	public int totalPositivosEnUnDia(Date fecha) {
		return crearStream()
						.filter(c -> c.getFecha().compareTo(fecha) == 0)
						.mapToInt(c -> c.getPositivos())
						.sum();
	}
	
	public Date fechaPicoContagios() {
		return crearStream()
					.max((c1, c2) -> c1.getPositivos() < c2.getPositivos() ? -1 : 1)
					.get()
					.getFecha();
	}
	
	public int totalMediaPositivosDiarios(Date fecha) {
		return (int) crearStream()
						.filter(c -> c.getFecha().compareTo(fecha) == 0)
						.mapToInt(c -> c.getPositivos())
						.average()
						.orElse(0);
	}
	
	public int totalPositivosComunidad(String comunidad) {
		return crearStream()
						.filter(c -> c.getNombreComunidad().equals(comunidad))
						.mapToInt(c -> c.getPositivos())
						.sum();
	}
	
	public Map<String, List<Caso>> casosComunidad(String comunidad) {
		return crearStream()
						.filter(c -> c.getNombreComunidad().equals(comunidad))
						.collect(Collectors.groupingBy(c -> c.getNombreComunidad()));
	}
	
	private Stream<Caso> crearStream() {
		try {
			return Files.lines(path).map(c -> Utilidades.construirCaso(c, separador));
		} catch (Exception e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getSeparador() {
		return separador;
	}

	public void setSeparador(String separador) {
		this.separador = separador;
	}
	
}
