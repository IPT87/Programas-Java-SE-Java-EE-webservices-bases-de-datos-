package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tareas.TareaPedidos;

public class ProcesarPedidos {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<?> f1 = executor.submit(new TareaPedidos("tienda A", "pedido_tienda1.txt"));
		Future<?> f2 = executor.submit(new TareaPedidos("tienda B", "pedido_tienda2.txt"));
		Future<?> f3 = executor.submit(new TareaPedidos("tienda C", "pedido_tienda3.txt"));
		
		while (!f1.isDone() || !f2.isDone() || !f3.isDone()) {
			System.out.println("Procesando...");
		}
		
		System.out.println("Tareas completadas.");
		
		executor.shutdown();
	}

}
