package service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Datos {
	public static Stream<JSONObject> obtenerStream () {		
		JSONParser parser = new JSONParser();
		JSONArray array = null;
			try {
				URL dir = new URL("https://restcountries.eu/rest/v2/all");
				HttpURLConnection conn = (HttpURLConnection)dir.openConnection();
				array = (JSONArray) parser.parse(new InputStreamReader(conn.getInputStream()));
				Stream<JSONObject> st = (Stream<JSONObject>)array.stream();
				return st;
			} catch (ParseException e) {
				e.printStackTrace();
				return Stream.empty();
			} catch (IOException e) {
				e.printStackTrace();
				return Stream.empty();
			}
			
	}

}
