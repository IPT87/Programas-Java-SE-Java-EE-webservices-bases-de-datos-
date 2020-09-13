package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Caso;
import service.CasosService;

public class LeerEstadisticas {
	private static Scanner scan = new Scanner(System.in);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		
		CasosService service = new CasosService(recibirFuenteDatos());
		int opcion = 0;
		
		do {
			menuOpciones();
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case 1:
				casosPeriodo(service);
				break;
			case 2:
				totalPositivosEnUnDia(service);
				break;
			case 3:
				fechaMasContagios(service);
				break;
			case 4:
				mediaPositivosDia(service);
				break;
			case 5:
				positivosComunidad(service);
				break;
			case 6:
				casosPorComunidad(service);
				break;
			case 7:
				System.out.println("Hasta luego.");
				break;
			case 8:
				System.out.println(service.getComunidades());
			default:
				System.out.println("La opción NO es válida. Prueba otra vez");
				break;
			}
		} while (opcion != 7);
		
		scan.close();
	}
	
	private static String recibirFuenteDatos() {
		System.out.println("Introduce la ruta de la fuente de datos: ");
		return scan.nextLine();
	}
	
	private static void menuOpciones() {
		System.out.println("----------------------OPCIONES----------------------");
		System.out.println("1. Lista de casos producidos entre dos fechas dadas.");
		System.out.println("2. Total de positivos producidos en un determinado día.");
		System.out.println("3. Fecha en la que se produjo el pico de contagios.");
		System.out.println("4. Media de positivos diarios en un determinado día.");
		System.out.println("5. Total de positivos de una comunidad dada.");
		System.out.println("6. Tabla con listas de casos agrupados por comunidad.");
		System.out.println("7. Salir.");
	}
	
	private static void casosPeriodo(CasosService service) {
		System.out.println("Introduce la fecha inicial del periodo en formato año-mes-dia:");
		String fecha1 = scan.nextLine();
		System.out.println("Introduce la fecha final del periodo en formato año-mes-dia:");
		String fecha2 = scan.nextLine();
		
		try {
			Date fechaDesde = sdf.parse(fecha1);
			Date fechaHasta = sdf.parse(fecha2);
			
			System.out.println("Casos periodo " + fecha1 + "||" + fecha2 + ":");
			service.casosPorPeriodo(fechaDesde, fechaHasta).forEach(d -> System.out.println(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private static void totalPositivosEnUnDia(CasosService service) {
		System.out.println("Introduce la fecha en formato año-mes-dia:");
		String fecha = scan.nextLine();
		
		try {
			Date dia = sdf.parse(fecha);
			System.out.println("Total casos positivos dia " + fecha + ": " + service.totalPositivosEnUnDia(dia));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private static void fechaMasContagios(CasosService service) {
		System.out.println("Fecha pico contagios: " + sdf.format(service.fechaPicoContagios()));
	}
	
	private static void mediaPositivosDia(CasosService service) {
		System.out.println("Introduce la fecha en formato año-mes-dia:");
		String fecha = scan.nextLine();
		
		try {
			Date dia = sdf.parse(fecha);
			System.out.println("Media positivos en todo el pais para la fecha " + fecha + ": " + service.totalMediaPositivosDiarios(dia));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private static void positivosComunidad(CasosService service) {
		System.out.println("Introduce comunidad:");
		String comunidad = scan.nextLine();
		String codigo = "";
		
		switch (comunidad) {
		case "Andalucia":
			codigo = "AN";
			break;
		case "Aragon":
			codigo = "AR";
			break;
		case "Asturias":
			codigo = "AS";
			break;
		case "Cantabria":
			codigo = "CB";
			break;
		case "Ceuta":
			codigo = "CE";
			break;
		case "Castilla y Leon":
			codigo = "CL";
			break;
		case "Castilla-La Mancha":
			codigo = "CM";
			break;
		case "Canarias":
			codigo = "CN";
			break;
		case "Cataluña":
			codigo = "CT";
			break;
		case "Extremadura":
			codigo = "EX";
			break;
		case "Galicia":
			codigo = "GA";
			break;
		case "Islas Baleares":
			codigo = "IB";
			break;
		case "Murcia":
			codigo = "MC";
			break;
		case "Madrid":
			codigo = "MD";
			break;
		case "Melilla":
			codigo = "ML";
			break;
		case "Navarra":
			codigo = "NC";
			break;
		case "Pais Vasco":
			codigo = "PV";
			break;
		case "La Rioja":
			codigo = "RI";
			break;
		case "Valenciana":
			codigo = "VC";
			break;
		}
		System.out.println("Total casos positivos en comunidad " + comunidad + ": " + service.totalPositivosComunidad(codigo));
	}
	
	private static void casosPorComunidad(CasosService service) {
		System.out.println("Introduce comunidad:");
		String comunidad = scan.nextLine();
		String codigo = "";
		
		switch (comunidad) {
		case "Andalucia":
			codigo = "AN";
			break;
		case "Aragon":
			codigo = "AR";
			break;
		case "Asturias":
			codigo = "AS";
			break;
		case "Cantabria":
			codigo = "CB";
			break;
		case "Ceuta":
			codigo = "CE";
			break;
		case "Castilla y Leon":
			codigo = "CL";
			break;
		case "Castilla-La Mancha":
			codigo = "CM";
			break;
		case "Canarias":
			codigo = "CN";
			break;
		case "Cataluña":
			codigo = "CT";
			break;
		case "Extremadura":
			codigo = "EX";
			break;
		case "Galicia":
			codigo = "GA";
			break;
		case "Islas Baleares":
			codigo = "IB";
			break;
		case "Murcia":
			codigo = "MC";
			break;
		case "Madrid":
			codigo = "MD";
			break;
		case "Melilla":
			codigo = "ML";
			break;
		case "Navarra":
			codigo = "NC";
			break;
		case "Pais Vasco":
			codigo = "PV";
			break;
		case "La Rioja":
			codigo = "RI";
			break;
		case "Valenciana":
			codigo = "VC";
			break;
		}
		
		Map<String, List<Caso>> casos = service.casosComunidad(codigo);
		casos.forEach((k, p) -> p.forEach(c -> System.out.println("Casos " + comunidad + ": " + sdf.format(c.getFecha()) + ", " + c.getPositivos() + " casos positivos.")));
	}

}
