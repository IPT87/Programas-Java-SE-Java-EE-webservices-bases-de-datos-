package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Caso;
import util.Utilidades;

public class CasosService {

	private String fuente;
	
	public CasosService(String fuente) {
		this.fuente = fuente;
	}
	
	public List<Caso> casosPorPeriodo(Date fechaDesde, Date fechaHasta) {
		return crearJsonObjectStream()
						.map(c -> Utilidades.crearCaso(c))
						.filter(c -> c.getFecha().after(fechaDesde) && c.getFecha().before(fechaHasta))
						.collect(Collectors.toList());
	} 
	
	public int totalPositivosEnUnDia(Date fecha) {
		return (int) crearJsonObjectStream()
						.map(c -> Utilidades.crearCaso(c))
						.filter(c -> c.getFecha().compareTo(fecha) == 0)
						.mapToLong(c -> c.getPositivos())
						.sum();
	}
	
	public Date fechaPicoContagios() {
		return crearJsonObjectStream()
					.map(c -> Utilidades.crearCaso(c))
					.max((c1, c2) -> c1.getPositivos() < c2.getPositivos() ? -1 : 1)
					.get()
					.getFecha();
	}
	
	public int totalMediaPositivosDiarios(Date fecha) {
		return (int) crearJsonObjectStream()
							.map(c -> Utilidades.crearCaso(c))
							.filter(c -> c.getFecha().compareTo(fecha) == 0)
							.mapToLong(c -> c.getPositivos())
							.average()
							.orElse(0);
	}
	
	public int totalPositivosComunidad(String comunidad) {
		return (int) crearJsonObjectStream()
						.map(c -> Utilidades.crearCaso(c))
						.filter(c -> c.getNombreComunidad().equals(comunidad))
						.mapToLong(c -> c.getPositivos())
						.sum();
	}
	
	public Map<String, List<Caso>> casosComunidad(String comunidad) {
		return crearJsonObjectStream()
						.map(c -> Utilidades.crearCaso(c))
						.filter(c -> c.getNombreComunidad().equals(comunidad))
						.collect(Collectors.groupingBy(c -> c.getNombreComunidad()));
	}
	
	private Stream<JSONObject> crearJsonObjectStream() {
		JSONParser parse = new  JSONParser();
		Stream<JSONObject> st = null;
		
		try {
			try {
				JSONArray array = (JSONArray) parse.parse(new FileReader(fuente));
				st = (Stream<JSONObject>) array.stream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return st;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	
}
