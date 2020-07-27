package principal;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import recurso.Acumulador;

public class TareaMultiplicacion implements Runnable {

	private int numero;
	private Acumulador acumulador;
	private static Lock lc = new ReentrantLock();

	public TareaMultiplicacion(int numero, Acumulador acumulador) {
		this.numero = numero;
		this.acumulador = acumulador;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero + " x " + i + " = " + (numero * i));

			lc.lock();
				int valor = acumulador.getValor();
				valor++;

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				acumulador.setValor(valor);
			lc.unlock();
		}

		System.out.println("Valor actual del acumulador: " + acumulador.getValor());

	}

}
