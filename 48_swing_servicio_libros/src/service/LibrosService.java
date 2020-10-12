package service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONObject;

import model.Libro;

public class LibrosService {
	public List<Libro> recuperarTodos() {
		Stream<JSONObject> stream = DatosRemotos.getJson();
		return stream
				.map(ob -> Utilidades.adaptadorJsonALibro(ob))
				.collect(Collectors.toList());
	}

	public List<Libro> recuperarPorTema(int idTema) {
		Stream<JSONObject> stream = DatosRemotos.getJson();
		return stream
				.map(ob -> Utilidades.adaptadorJsonALibro(ob))
				.filter(lib -> lib.getIdTema() == idTema)
				.collect(Collectors.toList());
	}

	public Libro recuperarPorIsbn(int isbn) {
		Stream<JSONObject> stream = DatosRemotos.getJson();
		return stream
				.map(ob -> Utilidades.adaptadorJsonALibro(ob))
				.filter(lib -> lib.getIsbn() == isbn)
				.findFirst()
				.orElse(null);
	}
}
