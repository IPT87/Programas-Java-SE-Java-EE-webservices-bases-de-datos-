package util;

import org.json.simple.JSONObject;

import model.Pais;

public class Utilidades {
	public static Pais adaptadorAPais(JSONObject object) {
		return new Pais((String)object.get("name"),
						(String)object.get("region"),
						(String)object.get("capital"),
						(Long)object.get("population"),
						(String)object.get("flag"));
	}
}
