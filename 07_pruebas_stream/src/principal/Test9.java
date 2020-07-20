package principal;

import java.util.stream.Stream;

public class Test9 {

	public static void main(String[] args) {
		Stream<String> cursos=Stream.of("Java","JavaScript","PHP",".NET","c++","Aprenda Java ya","Python","Java EE","Todo Java","Linux");

		System.out.println(cursos
				.map(c -> c.toLowerCase())
				.filter(c -> c.contains("java"))
				.sorted()
				.findFirst()
				.orElse("No encontrado"));
	}

}
