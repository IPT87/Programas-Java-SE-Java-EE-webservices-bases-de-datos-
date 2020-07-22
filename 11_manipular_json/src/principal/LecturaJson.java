package principal;

import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecturaJson {

	public static void main(String[] args) {
		String json = "[{\"numeroPedido\":200, \"producto\":\"Galletas\",\"precio\":20.5}," +
				"{\"numeroPedido\":100, \"producto\":\"Balón\",\"precio\":2.2}]";
		
		//crear objeto JSONParser
		JSONParser parse = new  JSONParser();
		
		try {
			JSONArray array = (JSONArray) parse.parse(json);
			/* for (int i = 0; i < array.size(); i++) {
				JSONObject ob = (JSONObject) array.get(i);
				System.out.println(ob.get("producto"));
			} */
			// array.forEach(e -> System.out.println(((JSONObject) e).get("producto")));
			Stream<JSONObject> st = (Stream<JSONObject>) array.stream();
			st.forEach(e -> System.out.println(e.get("producto")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
