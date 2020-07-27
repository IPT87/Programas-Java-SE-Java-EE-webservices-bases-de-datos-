package tareas;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Long>{

	private int n;
	
	public Factorial(int n) {
		this.n = n;
	}
	
	@Override
	public Long call() {
		long aux = 1;
		
		for (int i = 1; i <= n; i++) {
			aux *= i;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return aux;
	}

}
