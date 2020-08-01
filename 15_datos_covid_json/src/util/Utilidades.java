package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONObject;
import model.Caso;

public class Utilidades {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Caso crearCaso(JSONObject jo) {
		Caso caso = null;
		
		try {
			caso = new Caso((String) jo.get("ccaa_iso"), (Date) sdf.parse(jo.get("fecha").toString()), (long) jo.get("num_casos"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return caso;
	}
}
