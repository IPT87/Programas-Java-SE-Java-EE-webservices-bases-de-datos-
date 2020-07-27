package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tareas.Factorial;

public class TestFactorial {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Long> future = executor.submit(new Factorial(7));
		
		while (!future.isDone()) {
			System.out.println("Haciendo cosas en el main.");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			System.out.println("El resultado del factorial es " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}

}
