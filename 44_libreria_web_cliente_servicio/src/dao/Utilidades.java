package dao;

import org.json.simple.JSONObject;

import model.Libro;

public class Utilidades {
	public static Libro adaptadorJsonALibro(JSONObject object) {
		return new Libro(((Long)object.get("isbn")).intValue(),
						 (String)object.get("titulo"),
						 (String)object.get("autor"),
						 (Double)object.get("precio"),
						 0,
						 ((Long)((JSONObject)object.get("tematica")).get("id")).intValue());
	}
}
