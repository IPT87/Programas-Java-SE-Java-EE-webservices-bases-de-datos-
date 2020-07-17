package principal;

import java.util.Scanner;

import recurso.Acumulador;

public class Lanzador {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int tareas = 2;
		int nums[] = new int[tareas];
		Acumulador acumulador = new Acumulador();
		
		for (int i = 0; i < tareas; i++) {
			System.out.println("Introduce un numero: ");
			nums[i] = Integer.parseInt(scan.nextLine());
		}
		
		scan.close();
		
		for (int n : nums) {
			lanzador(new TareaMultiplicacion(n, acumulador));
		}

	}
	
	private static void lanzador(Runnable r) {
		new Thread(r).start();
	}

}
