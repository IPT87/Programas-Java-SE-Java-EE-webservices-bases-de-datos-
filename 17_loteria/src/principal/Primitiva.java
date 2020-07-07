package principal;

import java.util.ArrayList;
import java.util.Collections;

public class Primitiva {

	public static void main(String[] args) {

		ArrayList<Integer> numeros = new ArrayList<>();

		sorteo(numeros);

		imprimirNumeros(numeros);

	}

	static void sorteo(ArrayList<Integer> numeros) {

		int numero;

		while (numeros.size() < 6) {

			numero = (int) (Math.random() * 46 + 1);

			if (!numeros.contains(numero)) {
				numeros.add(numero);
			}
		}
	}

	static void imprimirNumeros(ArrayList<Integer> numeros) {

		System.out.println("Combinación ganadora: ");
		
		Collections.sort(numeros);

		for (Integer element : numeros) {

			System.out.print(element + " ");
		}
	}

}
