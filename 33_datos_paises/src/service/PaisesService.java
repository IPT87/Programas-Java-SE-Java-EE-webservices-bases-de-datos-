package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Pais;
import model.PaisInfo;
import util.Utilidades;

public class PaisesService {
	
	private String fuente;

	
	public PaisesService(String fuente) {
		super();
		this.fuente = fuente;
	}

	public List<Pais> paisesPorRegion(String region) {
		List<PaisInfo> listaInfo = crearJsonObjectStream()
									.map(p -> Utilidades.crearPaisInfo(p))
									.filter(p -> p.getRegion().toLowerCase().equals(region.toLowerCase()))
									.collect(Collectors.toList());
		
		List<Pais> listaPaises = new ArrayList<Pais>();
		listaInfo
			.forEach(p -> listaPaises.add(new Pais(p.getNombre(), p.getCapital(), p.getArea(), p.getPoblacion())));
		
		return listaPaises;
	}
	
	public Pais paisMasPoblado() {
		return crearJsonObjectStream()
				.map(p -> Utilidades.crearPais(p))
				.max((p1, p2) -> (int) (p1.getPoblacion() - p2.getPoblacion()))
				.get();
	}
	
	public int paisesPorNumHabitantesIndicado(int numeroHabitantes) {
		return (int) crearJsonObjectStream()
				.filter(p -> (long) p.get("population") > numeroHabitantes)
				.count();
	}
	
	public List<Pais> paisesConNombresConteniendoIndicado(String letras) {
		return crearJsonObjectStream()
				.map(p -> Utilidades.crearPais(p))
				.filter(p -> p.getNombre().toLowerCase().contains(letras.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	public Map<String, String> posicionPais(String alpha2Code) {
		return crearJsonObjectStream()
				.map(p -> Utilidades.crearPaisInfo(p))
				.filter(p -> p.getAlpha2Code().toLowerCase().equals(alpha2Code.toLowerCase()))
				.collect(Collectors.toMap(p ->  p.getCoordenadas().toJSONString().split(",")[0], p -> p.getCoordenadas().toJSONString().split(",")[1]));
    }
	
	public long poblacionMediaRegion(String region) {
		return (long) crearJsonObjectStream()
				.map(p -> Utilidades.crearPaisInfo(p))
				.filter(p -> p.getRegion().toLowerCase().equals(region.toLowerCase()))
				.mapToLong(p -> p.getPoblacion())
				.average()
				.orElse(0);
    }
	
	public Map<String, Long> poblacionPorRegion() {
		Map<String, List<PaisInfo>> mapRegion = crearJsonObjectStream()
													.map(p -> Utilidades.crearPaisInfo(p))
													.collect(Collectors.groupingBy(p -> p.getRegion()));
		
		Map<String, Long> poblacionRegion = new HashMap<>();
		
		mapRegion.forEach((k, v) -> poblacionRegion.put(k, v.stream().mapToLong(p -> p.getPoblacion()).sum()));
		
		return poblacionRegion;
	}
	
	private Stream<JSONObject> crearJsonObjectStream() {
		JSONParser parse = new JSONParser();
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
