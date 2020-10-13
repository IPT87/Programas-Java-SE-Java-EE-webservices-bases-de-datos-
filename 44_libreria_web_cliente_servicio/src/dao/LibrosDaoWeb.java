package dao;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.json.simple.JSONObject;

import model.Libro;

@RequestScoped
@Named("librosDaoWeb")
public class LibrosDaoWeb implements LibrosDao {

	@Override
	public List<Libro> recuperarTodos() {
		Stream<JSONObject> stream = DatosRemotos.getJson();
		return stream
				.map(ob -> Utilidades.adaptadorJsonALibro(ob))
				.collect(Collectors.toList());
	}

	@Override
	public List<Libro> recuperarPorTema(int idTema) {
		Stream<JSONObject> stream = DatosRemotos.getJson();
		return stream
				.map(ob -> Utilidades.adaptadorJsonALibro(ob))
				.filter(l -> l.getIdTema() == idTema)
				.collect(Collectors.toList());
	}

	@Override
	public Libro recuperarPorIsbn(int isbn) {
		Stream<JSONObject> stream = DatosRemotos.getJson();
		return stream
				.map(ob -> Utilidades.adaptadorJsonALibro(ob))
				.filter(l -> l.getIsbn() == isbn)
				.findFirst()
				.get();
	}
	
}
