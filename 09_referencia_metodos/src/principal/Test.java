package principal;

import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		Stream<String> nombres = Stream.of("Pepe", "Lucas", "Ana", "Marcos", "Pepe", "Marta", "Juan", "Lucas", "Elena");
		nombres
			.distinct()
			// el metodo length se aplica al tipo String
			.map(String::length)
			.forEach(n -> System.out.println(n));

	}

}
