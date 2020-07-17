package servicio;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import model.Persona;

public class PersonasService {
	
	
	public void imprimir(List<Persona> personas, Predicate<Persona> condicion) {
		for (Persona persona : personas) {
			if (condicion.test(persona)) {
				System.out.println(persona.getNombre());
			}
		}
	}
	
	public void imprimir(List<Persona> personas, Predicate<Persona> condicion, Function<Persona, String> transformacion) {
		for (Persona persona : personas) {
			if (condicion.test(persona)) {
				System.out.println(transformacion.apply(persona));
			}
		}
	}
	
	public void procesar(List<Persona> personas, Predicate<Persona> condicion, Consumer<Persona> procesado) {
		for (Persona persona : personas) {
			if (condicion.test(persona)) {
				procesado.accept(persona);
			}
		}
	}
}
