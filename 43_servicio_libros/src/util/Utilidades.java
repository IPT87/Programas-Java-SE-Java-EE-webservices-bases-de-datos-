package util;

import org.json.simple.JSONObject;

import model.Libro;

public class Utilidades {
	public static JSONObject adaptadorLibroAJSON(Libro libro) {
		JSONObject ob = new JSONObject();
		ob.put("titulo", libro.getTitulo());
		ob.put("tematica", libro.getTema().getTema());
		ob.put("autor", libro.getAutor());
		ob.put("precio", libro.getPrecio());
		
		return ob;
	}
}
