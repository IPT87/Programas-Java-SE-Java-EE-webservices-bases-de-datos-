package dao;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DatosRemotos {
	static String dir="http://localhost:8080/43_servicio_libros/LibrosAction";
	public static Stream<JSONObject> getJson(){
		try {
			URL url=new URL(dir);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			JSONParser parser=new JSONParser();
			JSONArray array=(JSONArray)parser.parse(new InputStreamReader(con.getInputStream()));
			return (Stream<JSONObject>)array.stream();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
		
		
	}
}
