package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;


import model.Pedido;
import util.Utilidades;

public class PedidoService {
	private final String RUTA = "C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\pedidos.txt";
	private final String SEPARADOR = ",";
	private Path path;
	
	public PedidoService() {
		path = Paths.get(RUTA);
	}

	public boolean agregarPedido(Pedido pedido) {
		if (!existePedido(pedido)) {
			try {
				Files.writeString(
						path, 
						Utilidades.construirCadena(pedido, SEPARADOR) + System.lineSeparator(), 
						StandardOpenOption.APPEND);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private boolean existePedido(Pedido pedido) {
		try {
			return Files.lines(path)
					.anyMatch(p -> Utilidades.construirPedido(p, SEPARADOR).equals(pedido));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Pedido procesarPedido() {
		List<Pedido> pedidos = pedidosPendientes();
		Pedido pedido = null;
		if (pedidos.size() > 0) {
			pedido = pedidos.remove(0);
			volcarPedidos(pedidos);
		}
		return pedido;
	}

	// reconstruye el fichero con la nueva lista de pedidos
	private void volcarPedidos(List<Pedido> pedidos) {
		try {
			Files.write(
					path, 
					pedidos
					.stream()
					.map(p -> Utilidades.construirCadena(p, SEPARADOR))
					.collect(Collectors.toList()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public Pedido priorizarPedido(int numeroPedido) {
		Pedido pedido, aux;
		pedido = obtenerPedido(numeroPedido);
		// obtenemos la lista de peidos pedientes,
		// para operar en memoria
		List<Pedido> pedidos = pedidosPendientes();
		if (pedido != null) {
			int pos = pedidos.indexOf(pedido);
			// se intercambia con el anterior, si no es el primero
			if (pos > 0) {
				// intercambiamos el pedido por el de la
				// posición anterior
				aux = pedidos.get(pos - 1);
				pedidos.set(pos - 1, pedido);
				pedidos.set(pos, aux);
			}
		}
		volcarPedidos(pedidos);
		return pedido;

	}

	private Pedido obtenerPedido(int numeroPedido) {
		try {
			return Files.lines(path)
					.map(p -> Utilidades.construirPedido(p, SEPARADOR))
					.filter(p -> p.getNumero() == numeroPedido)
					.findFirst()
					.orElse(null);
		} catch (IOException e) {
			e.getStackTrace();
		}
		return null;
		
	}

	public double facturacionPendiente() {
		try {
			return Files.lines(path)
					.mapToDouble(p -> Utilidades.construirPedido(p, SEPARADOR).getPrecio())
					.sum();	
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return 0.0;
	}

	// elimina todos los pedidos, cuyo nombre de producto
	// contenga ese texto
	public void eliminarPedidos(String producto) {
		List<Pedido> pedidos = pedidosPendientes();
		pedidos.removeIf(p -> p.getProducto().equals(producto));
		volcarPedidos(pedidos);
	}

	public List<Pedido> pedidosPendientes() {
		try {
			return Files.lines(path)
					.map(p -> Utilidades.construirPedido(p, SEPARADOR))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
