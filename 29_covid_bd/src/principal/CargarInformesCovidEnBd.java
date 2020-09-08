package principal;

import java.text.ParseException;
import java.util.Scanner;

import service.BaseService;
import service.CsvService;
import service.JsonService;

public class CargarInformesCovidEnBd {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		int opcion = 0;
		
		do {
			menu();
			
			try {
				opcion = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduce un numero!");
				System.out.println();
			}
			
			switch (opcion) {
			case 1:
				cargarDatos();
				break;
			case 2:
				System.out.println("Hasta luego!");
				break;
			}
		} while (opcion != 2);
		
		scan.close();
	}

	private static void menu() {
		System.out.println("--------OPCIONES--------");
		System.out.println("1. Cargar datos.");
		System.out.println("2. Salir.");
		System.out.println();
	}
	
	private static void cargarDatos() {
		System.out.println("Introduce la direccion del fichero con los informes COVID-19:");
		String ruta = scan.nextLine();
		
		if (ruta.endsWith(".json")) {
			BaseService service = new JsonService(ruta);
			service.streamCaso().forEach(c -> service.addCaso(c));
		} else if (ruta.endsWith(".csv")) {
			BaseService service = new CsvService(ruta);
			service.streamCaso().forEach(c -> service.addCaso(c));
		}
		
	}
	
}
