package principal;

import recurso.Acumulador;

public class TareaMultiplicacion implements Runnable {

	private int numero;
	private Acumulador acumulador;

	public TareaMultiplicacion(int numero, Acumulador acumulador) {
		this.numero = numero;
		this.acumulador = acumulador;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero + " x " + i + " = " + (numero * i));

			synchronized (acumulador) {
				int valor = acumulador.getValor();
				valor++;

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				acumulador.setValor(valor);
			}
		}

		System.out.println("Valor actual del acumulador: " + acumulador.getValor());

	}

}
