package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import model.Pedido;
import util.Utilidades;

public class GestorPedidos  {
	private final String SEPARADOR = ",";
	private Path path;
	private String dir="C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\pedidos.txt";
	
	public GestorPedidos() {
		path = Paths.get(dir);
	}
	
	//almacena el pedido recibido
	public void grabarPedido(Pedido pedido) {
		try {
			Files.writeString(
					path, 
					Utilidades.construirCadena(pedido, SEPARADOR) + System.lineSeparator(), 
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//media de ventas pedidos de esa seccion
	public double promedioSeccion(String seccion) {
		try {
			return Files.lines(path)
					.map(p -> Utilidades.construirPedido(p, SEPARADOR))
					.filter(p -> p.getSeccion().equals(seccion))
					.collect(Collectors.averagingDouble(p -> p.getPrecioUnitario() * p.getUnidades()));	
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return 0.0;
	}

	//ventas totales de el producto indicado
	public double totalProducto(String producto) {
		try {
			return Files.lines(path)
					.map(p -> Utilidades.construirPedido(p, SEPARADOR))
					.filter(p -> p.getSeccion().equals(producto))
					.mapToDouble(p -> p.getPrecioUnitario())
					.sum();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return 0.0;
	}

	//devuelve el pedido con venta superior
	public Pedido pedidoSuperior() {
		try {
			Files.lines(path)
					.map(p -> Utilidades.construirPedido(p, SEPARADOR))
					.max((p1 ,p2) -> p1.getUnidades() * p1.getPrecioUnitario() < p2.getUnidades() * p2.getPrecioUnitario() ? -1 : 1)
					.orElse(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//devuelve lista de pedidos de una sección
	public List<Pedido> pedidosSeccion(String seccion) {
		try {
			return Files.lines(path)
						.map(p -> Utilidades.construirPedido(p, SEPARADOR))
						.filter(p -> p.getSeccion().equals(seccion))
						.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//devuelve el pedido con fecha más reciente
	public Pedido pedidoMasReciente() {
		try {
			return Files.lines(path)
						.map(p -> Utilidades.construirPedido(p, SEPARADOR))
						.max((p1, p2) -> p1.getFecha().compareTo(p2.getFecha()))
						.orElse(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//devuelve lista de pedidos, posteriores a la fecha indicada
	public List<Pedido> pedidosPosterioresFecha(Date fecha) {
		try {
			return Files.lines(path)
						.map(p -> Utilidades.construirPedido(p, SEPARADOR))
						.filter(p -> p.getFecha().after(fecha))
						.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//lista de nombres de sección, no repetidas
	public List<String> secciones() {
		try {
			return Files.lines(path)
						.map(p -> Utilidades.construirPedido(p, SEPARADOR).getSeccion())
						// usando referencia a medodo en vez de lambda
						//.map(p -> (Pedido::getSeccion)
						.distinct()
						.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Pedido> pedidoRangoFecha(LocalDate fecha, Period periodo) {
		LocalDate fechaFin = fecha.plus(periodo);
		
		try {
			return Files.lines(path)
						.map(p -> Utilidades.construirPedido(p, SEPARADOR))
						.filter(p -> p.getFecha().after(Utilidades.convertirLocalDateEnDate(fecha))
								&& p.getFecha().before(Utilidades.convertirLocalDateEnDate(fechaFin)))
						.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
