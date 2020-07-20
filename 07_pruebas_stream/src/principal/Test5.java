package principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test5 {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(7, 21, 45, 4, 2, 7, 9, 10, 21, 7, 45, 73, 14);
		Stream<Integer> numeros = lista.stream();
		numeros
			.distinct()
			.filter(n -> n % 2 == 0)
			.sorted()
			.forEach(n -> System.out.println(n));
		
		// Stream no cambia la lista
		System.out.println("----------");
		lista.forEach(n -> System.out.println(n));
	}

}
