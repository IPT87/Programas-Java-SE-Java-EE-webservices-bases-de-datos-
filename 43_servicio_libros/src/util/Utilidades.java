package util;

import org.json.simple.JSONObject;

import model.Libro;

public class Utilidades {
	public static JSONObject adaptadorLibroAJson(Libro libro) {
		JSONObject ob=new JSONObject();
		ob.put("isbn", libro.getIsbn());
		ob.put("titulo", libro.getTitulo());
		//la propiedad temática es un subobjeto JSON
		//con los datos del tema
		JSONObject obTema=new JSONObject();
		obTema.put("id", libro.getTema().getIdTema());
		obTema.put("nombre", libro.getTema().getTema());
		ob.put("tematica", obTema);
		
		ob.put("autor", libro.getAutor());
		ob.put("precio", libro.getPrecio());
		return ob;
	}
}
