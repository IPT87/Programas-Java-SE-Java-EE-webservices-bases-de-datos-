package principal;

import java.util.function.Predicate;

import service.TestingPares;
import service.TestingPrimos;

public class Pruebas {

	public static void main(String[] args) {
		int[] numeros = { 6, 25, 8, 11, 14, 17, 13 };

		// Usando clases
		// comprobaciones(numeros, new TestingPares(), new TestingPrimos());
		
		// No es necesario crear clases, usamos lambda
		Predicate<Integer> tpares = i -> i % 2 == 0;
		Predicate<Integer> tprimos = i -> {
			for (int k = 2; i < i; k++) {
				if (k % i == 0) {
					return false;
				}
			}
			return true;
		};
		
		comprobaciones(numeros, tpares, tprimos);

	}

	private static void comprobaciones(int[] numeros, Predicate<Integer> pares, Predicate<Integer> primos) {
		for (int num : numeros) {
			if (pares.test(num)) {
				System.out.println("El numero " + num + " es par.");
			}

			if (primos.test(num)) {
				System.out.println("El numero " + num + " es primo.");
			}
		}
	}

}
