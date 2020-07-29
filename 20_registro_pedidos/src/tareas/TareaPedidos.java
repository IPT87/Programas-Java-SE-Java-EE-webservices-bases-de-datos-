package tareas;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import model.Pedido;
import model.PedidoTienda;
import service.GestorPedidos;

public class TareaPedidos implements Runnable {
	private static Lock lc = new ReentrantLock();
	private String nombreTienda;
	private String ruta;
	
	
	public TareaPedidos(String nombreTienda, String ruta) {
		super();
		this.nombreTienda = nombreTienda;
		this.ruta = ruta;
	}


	@Override
	public void run() {
		GestorPedidos service = new GestorPedidos();
		List<Pedido> listaPedidosHoy = service.pedidosFechaActual();
	
		lc.lock();
		service.grabarPedido(listaPedidosHoy.stream()
					.map(p -> new PedidoTienda(p.getProducto(), 
							p.getUnidades(), 
							p.getPrecioUnitario(), 
							p.getSeccion(), 
							p.getFecha(), 
							nombreTienda))
							.collect(Collectors.toList()));
		lc.unlock();
	}
}
