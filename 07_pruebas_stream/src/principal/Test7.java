package principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test7 {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(7, 21, 45, 4, 2, 7, 9, 10, 21, 7, 45, 73, 14);
		final int LM = 10;
		Stream<Integer> numeros = lista.stream();
		
		// Comprueba sy algun elemento del stream es mayor que el limite
		/* System.out.println(numeros
			.anyMatch(n -> n > LM)); */
		
		// anyMatch funciona de modo corto circuito,
		// si encuentra un elemento que no cumple los requisitos
		// para alli y no sigue con los demas elementos
		System.out.println(numeros
			.anyMatch(n -> {
			System.out.println(n);
			return n > LM; }));
	}

}
