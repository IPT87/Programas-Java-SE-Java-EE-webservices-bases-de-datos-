package principal;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {
static ExecutorService executor = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int tareas = 3;
		int nums[] = new int[tareas];
		
		for (int i = 0; i < tareas; i++) {
			System.out.println("Introduce un numero: ");
			nums[i] = Integer.parseInt(scan.nextLine());
		}
		
		scan.close();
		
		for (int n : nums) {
			lanzador(new TareaMultiplicacion(n));
		}
		
		executor.shutdown();

	}
	
	private static void lanzador(Runnable r) {
		executor.submit(r);
	}

}
