package principal;

import java.util.Scanner;

public class GestionNotas {

	static double notaMedia;
	static int suspensos;
	static int aprobados;
	static int notables;
	static int sobresalientes;
	static double suma;

	public static void main(String[] args) {

		double[] notas = new double[5];

		leerNotas(notas);

		calcularNotas(notas);
		
		imprimirNotas();

	}

	// Lee el input del teclado usando Scanner y asigna valores a los elementos del array
	static void leerNotas(double[] valores) {

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < valores.length; i++) {
			System.out.println("Escribe nota: ");
			valores[i] = scan.nextDouble();
		}

		scan.close();
	}

	// Calcula las notas en categorias
	static void calcularNotas(double[] valores) {

		for (double nota : valores) {
			if (nota < 5) {
				suspensos++;
				suma += nota;
			} else if (nota < 7) {
				aprobados++;
				suma += nota;
			} else if (nota < 9) {
				notables++;
				suma += nota;
			} else {
				sobresalientes++;
				suma += nota;
			}
		}

		notaMedia = suma / valores.length;
	}

	// Imprime las categorias de las notas y la nota media
	static void imprimirNotas() {

		System.out.printf("Nota media: %.2f \n", notaMedia);
		System.out.println("Suspensos: " + suspensos);
		System.out.println("Aprobados: " + aprobados);
		System.out.println("Notables: " + notables);
		System.out.println("Sobresalientes: " + sobresalientes);
	}

}
