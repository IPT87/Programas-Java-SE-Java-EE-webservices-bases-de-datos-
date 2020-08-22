package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import util.Utilidades;

public class CasoService {
	private String fuente;

	
	public CasoService(String fuente) {
		super();
		this.fuente = fuente;
	}

	public long totalPositivos(String nombreComunidad) {
		return crearJsonObjectStream()
				.map(c -> Utilidades.crearCaso(c))
				.filter(c -> c.getNombreComunidad().equals(nombreComunidad))
				.mapToLong(c -> c.getPositivos())
				.sum();
	}
	
	public int totalMediaPositivosDiarios(String nombreComunidad) {
		return (int) crearJsonObjectStream()
							.map(c -> Utilidades.crearCaso(c))
							.filter(c -> c.getNombreComunidad().equals(nombreComunidad))
							.mapToLong(c -> c.getPositivos())
							.average()
							.orElse(0);
	}
	
	public Date fechaPicoContagios(String nombreComunidad) {
		return crearJsonObjectStream()
					.map(c -> Utilidades.crearCaso(c))
					.filter(c -> c.getNombreComunidad().equals(nombreComunidad))
					.max((c1, c2) -> c1.getPositivos() < c2.getPositivos() ? -1 : 1)
					.get()
					.getFecha();
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
