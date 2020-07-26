package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import model.Pedido;
import service.GestorPedidos;

public class Presentacion {

	public static void main(String[] args) throws ParseException {
		String[] fechas = {"11/08/2018", "16/09/2019", "01/01/2028", "25/04/2015", "11/11/2020"};
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GestorPedidos gestor = new GestorPedidos();
		gestor.grabarPedido(new Pedido("p1", 2, 2.5, "alimentacion", sdf.parse(fechas[0])));
		gestor.grabarPedido(new Pedido("p2", 5, 3, "deportes", sdf.parse(fechas[1])));
		gestor.grabarPedido(new Pedido("p3", 4, 3.5, "alimentacion", sdf.parse(fechas[2])));
		gestor.grabarPedido(new Pedido("p4", 3, 3.8, "deportes", sdf.parse(fechas[3])));
		gestor.grabarPedido(new Pedido("p5", 2, 2.6, "musica", sdf.parse(fechas[4])));
		
		/*gestor.pedidosPosterioresFecha(new Date()).forEach(p -> System.out.println(p.getProducto()));
		System.out.println(gestor.pedidoMasReciente().getProducto());
		System.out.println(gestor.promedioSeccion("alimentacion"));*/
		
		String fecha = "01/08/2014";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nFecha = LocalDate.parse(fecha, dtf);
		Period periodo = Period.ofYears(16);
		gestor.pedidoRangoFecha(nFecha, periodo)
									.forEach(p -> System.out.println(p.getProducto()));
	}

}
