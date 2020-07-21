package principal;

import java.util.List;
import java.util.Scanner;

import model.Pedido;
import service.PedidoService;

public class GestionarPedidos {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		PedidoService servicioPedidos = new PedidoService();

		int opcion = 0;

		do {
			menu();

			try {
				opcion = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			switch (opcion) {
			case 1:
				agregarPedido(servicioPedidos);
				break;
			case 2:
				procesarSiguiente(servicioPedidos);
				break;
			case 3:
				priorizar(servicioPedidos);
				break;
			case 4:
				facturacion(servicioPedidos);
				break;
			case 5:
				mostrarPendientes(servicioPedidos);
				break;
			case 6:
				eliminarPedidoPorNumero(servicioPedidos);
				break;
			case 7:
				System.out.println("Hasta luego.");
				break;
			default:
				System.out.println("La opción NO es válida. Prueba otra vez");
				break;
			}

		} while (opcion != 7);

		scan.close();

	}

	private static void menu() {

		System.out.println("----- MENÚ OPCIONES -----");
		System.out.println();
		System.out.println("1. Agregar Pedido");
		System.out.println("2. Procesar Pedido");
		System.out.println("3. Priorizar Pedido");
		System.out.println("4. Facturación Pendiente");
		System.out.println("5. Pedidos Pendientes");
		System.out.println("6. Eliminar pedido");
		System.out.println("7. Salir");
		System.out.println();
	}
	
	private static int leerNumeroPedido() {
		System.out.println("Introduce el número de pedido: ");
		return Integer.parseInt(scan.nextLine());
	}

	private static String leerProducto() {
		System.out.println("Introduce el nombre del producto: ");
		return scan.nextLine();
	}

	private static double leerPrecio() {
		System.out.println("Introduce el precio del producto: ");
		return Double.parseDouble(scan.nextLine());
	}
	
	private static boolean agregarPedido(PedidoService ps) {
		int id = 0;
		String producto = "";
		double precio = 0.0;
		
		try {
			id = leerNumeroPedido();

		} catch (NumberFormatException e) {
			System.out.println("El número de pedido no es válido");

			return false;
		}

		producto = leerProducto();

		try {
			precio = leerPrecio();

		} catch (NumberFormatException e) {
			System.out.println("El precio no es válido.");

			return false;
		}

		if ((id > 0) && (precio > 0)) {

			Pedido pedido = new Pedido(id, producto, precio);

			if (!ps.agregarPedido(pedido)) {
				System.out.println("El número de pedido ya EXISTE. Pedido NO registrado.");

				return false;
			}
			return true;
		}
		System.out.println("Los datos NO son válidos.");

		return false;
	}

	private static void procesarSiguiente(PedidoService ps) {
		Pedido siguiente = ps.procesarPedido();
		
		if (siguiente != null) {
			System.out.println("Se ha procesado el " + siguiente);
		} else {
			System.out.println("NO hay pedidos para procesar.");
		}
	}

	private static void priorizar(PedidoService ps) {

		if (ps.pedidosPendientes().size() != 0) {
			int id = leerNumeroPedido();

			Pedido pedido = ps.priorizarPedido(id);

			if (pedido != null) {
				System.out.println("Se ha priorizado el " + pedido);
			} else {
				System.out.println("NO se puede priorizar este pedido.");
			}
		} else {
			System.out.println("NO hay pedidos.");
		}
	}

	private static void facturacion(PedidoService ps) {
		System.out.println("FACTURACIÓN PENDIENTE: " + ps.facturacionPendiente());
	}

	private static void mostrarPendientes(PedidoService ps) {

		List<Pedido> pedidos = ps.pedidosPendientes();

		if (pedidos.size() != 0) {
			System.out.println("LISTA DE PEDIDOS PENDIENTES:");

			pedidos.forEach(p -> System.out.println(p));
		} else {
			System.out.println("NO hay pedidos pendientes.");
		}
	}
	
	private static void eliminarPedidoPorNumero(PedidoService ps) {
		System.out.println("Introduce el pedido que desea eliminar:");
		ps.eliminarPedidos(scan.nextLine());
	}

}
