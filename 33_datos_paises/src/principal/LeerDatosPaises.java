package principal;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import service.PaisesService;

public class LeerDatosPaises {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		PaisesService service = new PaisesService(recibirFuenteDatos());
		int opcion = 0;

		do {
			menuOpciones();
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case 1:
				paisesRegion(service);
				break;
			case 2:
				paisMasHabitantes(service);
				break;
			case 3:
				paisesConHabitantesIndicados(service);
				break;
			case 4:
				nombresPaisesConteniendoIndicado(service);
				break;
			case 5:
				longitudLatitudPais(service);
				break;
			case 6:
				mediaPoblacionRegion(service);
				break;
			case 7:
				poblacionTotalRegion(service);
				break;
			case 8:
				System.out.println("Hasta luego.");
				break;
			default:
				System.out.println("La opción NO es válida. Prueba otra vez");
				break;
			}
		} while (opcion != 8);
		
		scan.close();
	}

	private static String recibirFuenteDatos() {
		System.out.println("Introduce la ruta de la fuente de datos: ");
		return scan.nextLine();
	}
	
	private static void menuOpciones() {
		System.out.println("-------------------------------OPCIONES-------------------------------");
		System.out.println("1. Lista de paises pertenecientes a la región indicada.");
		System.out.println("2. País más poblado.");
		System.out.println("3. Total de países cuyo número de habitantes supere el valor indicado.");
		System.out.println("4. Paises cuyos nombres contengan la combinación de letras indicadas.");
		System.out.println("5. Posición (longitud y latitud) del país con alfa2code indicado.");
		System.out.println("6. Población media de la región indicada.");
		System.out.println("7. Tabla con las regiones y la población total de cada una.");
		System.out.println("8. Salir.");
	}
	
	private static void paisesRegion(PaisesService service) {
		System.out.println("Introduce region:");
		String region = scan.nextLine();
		
		System.out.println("Los paises de la region " + region + " son:");
		service.paisesPorRegion(region)
			.stream()
			.forEach(p -> System.out.println(p));
	}
	
	private static void paisMasHabitantes(PaisesService service) {
		System.out.println("El pais mas poblado es: " + service.paisMasPoblado().getNombre());
	}
	
	private static void paisesConHabitantesIndicados(PaisesService service) {
		System.out.println("Introduce el numero de habitantes:");
		int habitantes = Integer.parseInt(scan.nextLine());
		
		System.out.println("Total paises con mas de " + habitantes + " habitantes: " + service.paisesPorNumHabitantesIndicado(habitantes));
	}
	
	private static void nombresPaisesConteniendoIndicado(PaisesService service) {
		System.out.println("Introduce la combinacion de letras:");
		String letras = scan.nextLine();
		
		System.out.println("Paises cuyos nombres contienen la combinación de letras indicadas:");
		service.paisesConNombresConteniendoIndicado(letras)
			.forEach(p -> System.out.println(p.getNombre()));
	}
	
	private static void longitudLatitudPais(PaisesService service) {
		System.out.println("Introduce alpha2Code:");
		String alpha2code = scan.nextLine();
		
		for (Map.Entry<String, String> elemento : service.posicionPais(alpha2code).entrySet()) {
			System.out.println("Longitud: " + elemento.getKey() + ", latitud: " + elemento.getValue());
		}
	}
	
	private static void mediaPoblacionRegion(PaisesService service) {
		System.out.println("Introduce region:");
		String region = scan.nextLine();
		
		System.out.println("La media de la poblacion de la region " + region + " es: " + service.poblacionMediaRegion(region));
	}
	
	private static void poblacionTotalRegion(PaisesService service) {
		service.poblacionPorRegion().forEach((k, v) -> {
		if (!k.equals("Sin datos")) { 
			System.out.println("La población total de la región " + k + " es de " + v + " habitantes.");
		}});
	}
}
