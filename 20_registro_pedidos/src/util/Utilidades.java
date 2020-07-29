package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import model.Pedido;
import model.PedidoTienda;

public class Utilidades {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es"));

	public static Pedido construirPedido(String cadena, String separador) {
		String[] datos = cadena.split(separador);

		try {
			return new Pedido(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]), datos[3],
					sdf.parse(datos[4]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String pedidoTiendaToString (PedidoTienda pedido, String separador) {
		return pedido.getTienda() + separador + construirCadena(pedido, separador);
	}

	public static String construirCadena(Pedido pedido, String separador) {
		return pedido.getProducto() + separador + pedido.getUnidades() + separador + pedido.getPrecioUnitario()
				+ separador + pedido.getSeccion() + separador + sdf.format(pedido.getFecha());
	}
	
	public static LocalDate convertirDateEnLocalDate(Date fecha) {
		return  Instant.ofEpochMilli(fecha.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}
	
	public static Date convertirLocalDateEnDate(LocalDate fecha) {
		return Date.from(fecha
				.atStartOfDay(ZoneId.systemDefault())
				.toInstant());
	}
}
