package service;

import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class PedidoService {
	private List<Pedido> pilaPedidos;

	public PedidoService() {
		this.pilaPedidos = new ArrayList<>();
	}
	
	public void eliminarPedido(String pedido) {
		pilaPedidos.removeIf(p -> p.getProducto().contains(pedido));
	}

	public boolean agregarPedido(Pedido pedido) {
		if (!pilaPedidos.contains(pedido)) {
			pilaPedidos.add(pedido);
			return true;
		}
		return false;
	}

	public boolean procesarPedido() {
		if (!pilaPedidos.isEmpty()) {
			pilaPedidos.remove(0);
			return true;
		}
		return false;
	}

	public boolean priorizarPedido(int numero) {
		Pedido temp;

		for (int i = 0; i < pilaPedidos.size(); i++) {
			if (pilaPedidos.get(i).getNumero() == numero && i > 0) {
				temp = pilaPedidos.get(i - 1);
				pilaPedidos.set(i - 1, pilaPedidos.get(i));
				pilaPedidos.set(i, temp);
				return true;
			}
		}
		return false;
	}

	public List<Pedido> facturacionPendiente() {
		if (pilaPedidos.size() > 0) {
			return pilaPedidos;
		} else {
			return null;
		}
	}

	public List<String> nombresPedidosPendientes() {
		List<String> nombresProductos = new ArrayList<>();

		if (pilaPedidos.size() > 0) {
			for (Pedido producto : pilaPedidos) {
				nombresProductos.add(producto.getProducto());
			}
			return nombresProductos;
		} else {
			return null;
		}
	}

	public List<Pedido> getPilaPedidos() {
		return pilaPedidos;
	}

	public void setPilaPedidos(List<Pedido> pilaPedidos) {
		this.pilaPedidos = pilaPedidos;
	}

}
