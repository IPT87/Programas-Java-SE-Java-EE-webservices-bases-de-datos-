package principal;

import java.util.stream.Stream;

public class Test6 {

	public static void main(String[] args) {
		Stream<String> nombres = Stream.of("Pepe", "Lucas", "Ana", "Marcos", "Pepe", "Marta", "Juan", "Lucas", "Elena");
		System.out.println(nombres
			.distinct()
			.mapToInt(n -> n.length())
			.sum());
	}

}
