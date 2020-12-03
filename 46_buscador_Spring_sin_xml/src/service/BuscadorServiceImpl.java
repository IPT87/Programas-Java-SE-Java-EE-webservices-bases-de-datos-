package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Item;

@Service
public class BuscadorServiceImpl implements BuscadorService {
	List<Item> items = List.of(new Item("Casa del libro","http://casadellibro.es", new String[]{"libros","lectura","ocio"},"Libros y mas cosas"),
			new Item("La web del gamer","http://gamers.es", new String[]{"juegos","ordenadores","ocio"},"Todo sobre video juegos"),
			new Item("My computer","http://computerall.es", new String[]{"informatica","ordenadores"},"Ordenadores al mejor precio"),
			new Item("Fnac","http://fnac.es", new String[]{"juegos","ordenadores","libros"},"Bienvenido al mundo del ocio y la cultura"),
			new Item("Todo pelis","http://filmers.es", new String[]{"cine","peliculas","ocio"},"Entra en el mundo del cine"));
	
	@Override
	public List<Item> buscarItems(String tema) {
		List<Item> resultado = new ArrayList<>();
		
		if (comprobar(tema)) {
			for (var item : items) {
				for (var dato : item.getSeo()) {
					if (dato.equals(tema)) {
						resultado.add(item);
					}
				}
			}
		}
		return resultado;
	}
	
	private boolean comprobar(String palabra) {
		for(Item item : items) {
			for(String dato : item.getSeo()) {
				if(dato.equals(palabra)) {
					return true;
				}
			}
		}
		return false;
	}
}
