package principal;

import java.util.stream.Stream;

public class Test2 {

	public static void main(String[] args) {
		Stream<Integer> numeros = Stream.of(7, 21, 45, 4, 2, 7, 9, 10, 21, 7, 45, 73, 14);
		System.out.println("Total numeros sin duplicados: " + 
		numeros
				.distinct()
				.count());
	}

}
