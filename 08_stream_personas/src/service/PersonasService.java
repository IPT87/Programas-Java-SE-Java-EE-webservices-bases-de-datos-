package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Persona;

public class PersonasService {
	List<Persona> personas = new ArrayList<>();

	public PersonasService() {
		personas.add(new Persona("Alex", "al@gg.com", 20));
		personas.add(new Persona("Juan", "alfd@gg.com", 29));
		personas.add(new Persona("Elena", "al@gg.es", 17));
		personas.add(new Persona("Marta", "alaaoi@gg.com", 34));
		personas.add(new Persona("Lucas", "alert@gg.es", 44));
		personas.add(new Persona("Alicia", "sdfl@gg.com", 35));
		personas.add(new Persona("Santiago", "solp@dw.net", 50));
	}

	// persona mas joven
	public Persona obtenerMasJoven() {
		Stream<Persona> personasStream = personas.stream();
		return personasStream
				.min((n1, n2) -> n1.getEdad() - n2.getEdad())
				.get();
	}

	// el numero de personas cuya edad es superior a la media
	public int superiorMedia() {
		Stream<Persona> personasStream = personas.stream();
		double edadMedia = personasStream
				.mapToInt(p -> p.getEdad())
				.average()
				.getAsDouble();

		Stream<Persona> personasStream1 = personas.stream();
		return personasStream1
				.filter(p -> p.getEdad() > edadMedia)
				.collect(Collectors.toList()).size();
	}

	// personas ordenadas por edad
	public List<Persona> ordenadasPorEdad() {
		Stream<Persona> personasStream = personas.stream();
		return personasStream
				.sorted((p1, p2) -> p1.getEdad() - p2.getEdad())
				.collect(Collectors.toList());
	}

	// lista nombres de personas
	public List<String> nombres() {
		Stream<Persona> personasStream = personas.stream();
		return personasStream
				.map(p -> p.getNombre())
				.collect(Collectors.toList());
	}

	// dominio sea igual al indicado
	public List<Persona> personasDominio(String dominio) {
		Stream<Persona> personasStream = personas.stream();
		return personasStream
				.filter(p -> p.getEmail().endsWith(dominio))
				.collect(Collectors.toList());
	}

}
