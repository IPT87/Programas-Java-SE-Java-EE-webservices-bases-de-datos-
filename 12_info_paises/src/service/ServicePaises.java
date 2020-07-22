package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Pais;

public class ServicePaises {
	String json;

	public ServicePaises() {
		json = "[{\"country\":\"USA\",\"population\":249903450,\"capital\":\"washington\",\"temperature\":21.5,\"foundation\":1750,\"continent\":\"America\"},";
		json += "{\"country\":\"Canada\",\"population\":145290345,\"capital\":\"Ottawa\",\"temperature\":14.3,\"foundation\":1870,\"continent\":\"America\"},";
		json += "{\"country\":\"Spain\",\"population\":47345901,\"capital\":\"Madrid\",\"temperature\":24.7,\"foundation\":1520,\"continent\":\"Europe\"},";
		json += "{\"country\":\"Mexico\",\"population\":95000360,\"capital\":\"Mexico\",\"temperature\":26.2,\"foundation\":1880,\"continent\":\"America\"},";
		json += "{\"country\":\"Norway\",\"population\":31034000,\"capital\":\"Oslo\",\"temperature\":10.9,\"foundation\":1901,\"continent\":\"Europe\"},";
		json += "{\"country\":\"Germany\",\"population\":95456920,\"capital\":\"Berlin\",\"temperature\":18.0,\"foundation\":1830,\"continent\":\"Europe\"},";
		json += "{\"country\":\"Japan\",\"population\":110478934,\"capital\":\"Tokio\",\"temperature\":21.6,\"foundation\":1857,\"continent\":\"Asia\"},";
		json += "{\"country\":\"Russia\",\"population\":215678924,\"capital\":\"Moscow\",\"temperature\":11.3,\"foundation\":1802,\"continent\":\"Asia\"},";
		json += "{\"country\":\"France\",\"population\":76256702,\"capital\":\"Paris\",\"temperature\":19.4,\"foundation\":1670,\"continent\":\"Europe\"},";
		json += "{\"country\":\"United Kingdom\",\"population\":65023789,\"capital\":\"London\",\"temperature\":17.4,\"foundation\":1650,\"continent\":\"Europe\"}]";
	}

	public int paisesMasHabitantesValor(long habitantes) {
			return (int) crearJsonObjectStream()
						.filter(p -> (long) p.get("population") > habitantes)
						.count();			
	}

	public double temperaturaMediaPaises() {
			return crearJsonObjectStream()
					.mapToDouble(p -> (double) p.get("temperature"))
					.average()
					.getAsDouble();
	}

	public boolean algunPaisCondicion(long habitantesMax, long yearMenor) {
			return crearJsonObjectStream()
			.anyMatch(p -> (long) p.get("population") < habitantesMax && (long) p.get("foundation") < yearMenor);
	}

	public Pais paisMasPoblado() {
			return crearJsonObjectStream()
			.map(p -> crearPais(p))
			.max((p1, p2) -> (int) (p1.getHabitantes() - (int) p2.getHabitantes()))
			.orElse(null);
	}

	public List<Pais> paisesFundacionAnterior(long year) {
			return crearJsonObjectStream()
					.filter(p -> (long) p.get("foundation") < year)
					.map(p -> crearPais(p))
					.collect(Collectors.toList());
	}

	public String continenteConMasPaises() {
			Map<String, List<Pais>> map = paisesPorContinente();
			return map.keySet()
							.stream()
							.max((k1, k2) -> map.get(k1).size() - map.get(k2).size())
							.get();
	}

	public Map<String, List<Pais>> paisesPorContinente() {
			return crearJsonObjectStream()
					.map(p -> crearPais(p))
					.collect(Collectors.groupingBy(p -> p.getContinente()));
	}
	
	private Stream<JSONObject> crearJsonObjectStream() {
		JSONParser parse = new JSONParser();
		
		try {
			JSONArray array = (JSONArray) parse.parse(json);
			return (Stream<JSONObject>) array.stream();
		} catch (ParseException e) {
			e.printStackTrace();
			return Stream.empty();
		}
		
	}
	
	private Pais crearPais(JSONObject jo) {
		return new Pais((String) jo.get("country"), (String) jo.get("capital"), (long) jo.get("population"), (String) jo.get("continent"));
	}
	
}
