package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import model.CaseJson;
import model.Caso;

public class Utilidades {
	private static final String RUTA="datos.json";
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private static HashMap<String, String> comunidades = new HashMap<>();
	static {
		comunidades.put("AN", "Andalucía");
		comunidades.put("AR", "Aragón");
		comunidades.put("AS", "Asturias");
		comunidades.put("CN", "Canarias");
		comunidades.put("CB", "Cantabria");
		comunidades.put("CM", "Castilla-La Mancha");
		comunidades.put("CL", "Castilla y León");
		comunidades.put("CT", "Cataluña");
		comunidades.put("EX", "Extremadura");
		comunidades.put("GA", "Galicia");
		comunidades.put("IB", "Islas Baleares");
		comunidades.put("RI", "La Rioja");
		comunidades.put("MD", "Madrid");
		comunidades.put("MC", "Murcia");
		comunidades.put("NC", "Navarra");
		comunidades.put("PV", "País Vasco");
		comunidades.put("VC", "Valenciana");
		comunidades.put("CE", "Ceuta");
		comunidades.put("ML", "Melilla");
	}
	
	public static Caso stringToCaso(String f) {
		String[] partes=f.split("[,]");
		try {
			return new Caso(convertirAbreviaturaNombre(partes[0]),
					sdf.parse(partes[1]),
					Integer.parseInt(partes[2]));
		}
		catch(ParseException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static String convertirAbreviaturaNombre(String abr) {
		
			
		return comunidades.get(abr);
	}
	
	public static Caso convertirJsonACaso(CaseJson json) {
		return new Caso(convertirAbreviaturaNombre(json.getCcaa_iso()),json.getFecha(),json.getNum_casos());
	}
	
	public static Collection<String> getComunidades(){
		return comunidades.values();
	}
	
	public static int getOpcion() {
		JsonObject conn;
		try {
			conn = JsonParser.parseReader(new FileReader(RUTA)).getAsJsonObject();
			return conn.get("opcion").getAsInt();
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	public static String getRutaJson() {
		JsonObject conn;
		try {
			conn = JsonParser.parseReader(new FileReader(RUTA)).getAsJsonObject();
			return conn.get("rutaJson").getAsString();
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public static String getRutaCsv() {
		JsonObject conn;
		try {
			conn = JsonParser.parseReader(new FileReader(RUTA)).getAsJsonObject();
			return conn.get("rutaCsv").getAsString();
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}