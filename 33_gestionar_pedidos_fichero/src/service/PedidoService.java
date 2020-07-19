package service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class PedidoService {
	private List<Pedido> pilaPedidos;
	private String ruta = "C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\pedidos.txt";

	public PedidoService() {
		this.pilaPedidos = new ArrayList<>();
	}

	public boolean agregarPedido(Pedido pedido) {
		pilaPedidos = leerDatos();

		if (!pilaPedidos.contains(pedido)) {
			pilaPedidos.add(pedido);

			limpiarFichero();

			for (Pedido p : pilaPedidos) {
				String entrada = p.getNumero() + "," + p.getProducto() + "," + p.getPrecio();
				escribirDatos(entrada);
			}
			return true;
		}
		return false;
	}

	public boolean procesarPedido() {
		List<Pedido> pila = leerDatos();

		if (!pila.isEmpty()) {
			pila.remove(0);

			limpiarFichero();

			for (Pedido p : pila) {
				String entrada = p.getNumero() + "," + p.getProducto() + "," + p.getPrecio();
				escribirDatos(entrada);
			}
			return true;
		}
		return false;
	}

	public boolean priorizarPedido(int numero) {
		List<Pedido> pila = leerDatos();
		Pedido temp;

		for (int i = 0; i < pila.size(); i++) {
			if (pila.get(i).getNumero() == numero && i > 0) {
				temp = pila.get(i - 1);
				pila.set(i - 1, pila.get(i));
				pila.set(i, temp);

				limpiarFichero();

				for (Pedido p : pila) {
					String entrada = p.getNumero() + "," + p.getProducto() + "," + p.getPrecio();
					escribirDatos(entrada);
				}
				return true;
			}
		}
		return false;
	}

	public List<Pedido> facturacionPendiente() {
		List<Pedido> pila = leerDatos();

		if (pila.size() > 0) {
			return pila;
		} else {
			return null;
		}
	}

	public List<String> nombresPedidosPendientes() {
		List<Pedido> pila = leerDatos();
		List<String> nombresProductos = new ArrayList<>();

		if (pila.size() > 0) {
			for (Pedido producto : pila) {
				nombresProductos.add(producto.getProducto());
			}
			return nombresProductos;
		} else {
			return null;
		}
	}

	public boolean eliminarPedido(String pedido) {
		List<Pedido> pila = leerDatos();
		boolean resultado = pila.removeIf(p -> p.getProducto().contains(pedido));

		limpiarFichero();

		for (Pedido p : pila) {
			String entrada = p.getNumero() + "," + p.getProducto() + "," + p.getPrecio();
			escribirDatos(entrada);
		}

		return resultado;
	}

	private void limpiarFichero() {
		try (FileOutputStream fis = new FileOutputStream(ruta); PrintStream out = new PrintStream(fis);) {
			out.print("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Pedido> leerDatos() {
		List<Pedido> lista = new ArrayList<>();

		try (FileReader fr = new FileReader(ruta); BufferedReader bfr = new BufferedReader(fr)) {

			lista.clear();
			String linea = bfr.readLine();
			while (linea != null && !linea.isEmpty()) {
				String[] pedido = linea.split(",");
				lista.add(new Pedido(Integer.parseInt(pedido[0]), pedido[1], Double.parseDouble(pedido[2])));
				linea = bfr.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

	private void escribirDatos(String entrada) {
		try (FileOutputStream fis = new FileOutputStream(ruta, true); PrintStream out = new PrintStream(fis);) {
			out.println(entrada);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Pedido> getPilaPedidos() {
		return pilaPedidos;
	}

	public void setPilaPedidos(List<Pedido> pilaPedidos) {
		this.pilaPedidos = pilaPedidos;
	}

}
