package principal;

import java.util.Scanner;

public class GestionNotas {

	public static void main(String[] args) {
		
		double [] notas = new double[10];
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Escribe nota: ");
			notas[i] = scan.nextDouble();
		}
		
		scan.close();
		
		
		double notaMedia;
		int suspensos = 0;
		int aprobados = 0; 
		int notables = 0;
		int sobresalientes = 0;
		double suma = 0;
		
		for (double nota : notas) {
			if (nota < 5) {
				suspensos++;
				suma += nota;
			}else if (nota < 7) {
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
		
		notaMedia = suma / notas.length;
		
		System.out.println("Nota media: " + notaMedia);
		System.out.println("Suspensos: " + suspensos);
		System.out.println("Aprobados: " + aprobados);
		System.out.println("Notables: " + notables);
		System.out.println("Sobresalientes: " + sobresalientes);
	}

}
