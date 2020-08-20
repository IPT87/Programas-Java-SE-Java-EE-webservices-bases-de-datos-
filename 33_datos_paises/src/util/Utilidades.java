package util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Pais;
import model.PaisInfo;

public class Utilidades {
	
	public static Pais crearPais(JSONObject jo) {
		String nombre = (String) jo.get("name");
		String capital;
		double area;
		long habitantes = (long) jo.get("population");
		
		
		if(jo.get("capital") == (null) || jo.get("capital").equals("")) {
			capital = "Sin datos";
		} else {
			capital = (String) jo.get("capital");
		}
		
		if(jo.get("area") == (null) || jo.get("area").equals("")) {
			area = 0.0;
		} else {
			area = (double) jo.get("area");
		}
		
		return new Pais(nombre, capital, area, habitantes);
	}
	
	public static PaisInfo crearPaisInfo(JSONObject jo) {
		String region;
		String nombre = (String) jo.get("name");
		String capital;
		double area;
		String alpha2Code = (String) jo.get("alpha2Code");
		JSONArray coordenadas = (JSONArray) jo.get("latlng");
		long habitantes = (long) jo.get("population");
	
		
		if(jo.get("region") == (null) || jo.get("region").equals("")) {
			region = "Sin datos";
		} else {
			region = (String) jo.get("region");
		}
		
		if(jo.get("capital") == (null) || jo.get("capital").equals("")) {
			capital = "Sin datos";
		} else {
			capital = (String) jo.get("capital");
		}
		
		if(jo.get("area") == (null) || jo.get("area").equals("")) {
			area = 0.0;
		} else {
			area = (double) jo.get("area");
		}
		
		return new PaisInfo(region, nombre, capital, alpha2Code, coordenadas, area, habitantes);
	}
}
