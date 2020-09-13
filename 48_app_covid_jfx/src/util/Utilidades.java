package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONObject;
import model.Caso;

public class Utilidades {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	static HashMap<String, String> comunidades = new HashMap<>();
	
	static {
		comunidades.put("AN", "Andalucia");
		comunidades.put("AR", "Aragon");
		comunidades.put("AS", "Asturias");
		comunidades.put("CN", "Canarias");
		comunidades.put("CB", "Cantabria");
		comunidades.put("CM", "Castilla-La Mancha");
		comunidades.put("CL", "Castilla y Leon");
		comunidades.put("CT", "Cataluña");
		comunidades.put("EX", "Extremadura");
		comunidades.put("GA", "Galicia");
		comunidades.put("IB", "Islas Baleares");
		comunidades.put("RI", "La Rioja");
		comunidades.put("MD", "Madrid");
		comunidades.put("MC", "Murcia");
		comunidades.put("NC", "Navarra");
		comunidades.put("PV", "Pais Vasco");
		comunidades.put("VC", "Valenciana");
		comunidades.put("CE", "Ceuta");
		comunidades.put("ML", "Melilla");
	}
	
	public static String convertirAbreviaturaNombre(String abr) {
		return comunidades.get(abr);
	}
	
	public static Caso crearCaso(JSONObject jo) {
		Caso caso = null;
		
		try {
			caso = new Caso(convertirAbreviaturaNombre((String) jo.get("ccaa_iso")), (Date) sdf.parse(jo.get("fecha").toString()), (long) jo.get("num_casos"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return caso;
	}
}