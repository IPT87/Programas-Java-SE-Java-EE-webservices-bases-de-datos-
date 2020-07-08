package principal;

import java.util.Scanner;
import model.Ciudad;
import service.TemperaturasService;

public class GestionTemperaturas {

	public static void main(String[] args) {

		TemperaturasService service = new TemperaturasService();
		String opcion;
		boolean salir = false;

		do {

			Scanner scan = new Scanner(System.in);

			menu();

			opcion = scan.nextLine();

			switch (opcion) {
			case "1":
				altaTemperatura(service);
				break;
			case "2":
				System.out.println("Temperatura media " + service.media());
				break;
			case "3":
				System.out.println("Ciudad con temperatura mas alta " + service.mayor().getNombre());
				System.out.println("Ciudad con temperatura mas baja " + service.menor().getNombre());
				break;
			case "4":
				mostrarTemperatura(service);
				break;
			case "5":
				salir = true;
				scan.close();
				break;
			default:
				System.out.println("Opcion incorrecta...");
			}
		} while (!salir);

	}

	static void menu() {

		System.out.println("--------Opciones--------");
		System.out.println("1. Nueva temperatura");
		System.out.println("2. Temperatura media");
		System.out.println("3. Temperaturas extremas");
		System.out.println("4. Mostrar todas");
		System.out.println("5. Salir");
		System.out.println();
		System.out.println("Elige opcion: ");
	}
	
	static void altaTemperatura(TemperaturasService service) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre ciudad: ");
		String nombre = sc.nextLine();
		System.out.println("Temperatura ciudad: ");
		double temp = Double.parseDouble(sc.nextLine());
		Ciudad ciudad = new Ciudad(nombre, temp);
		
		if (service.agregarCiudad(ciudad)) {
			System.out.println("Ciudad añadida");
		} else {
			System.out.println("Ciudad repetida, prueba otra opcion");
		}
		
	}
	
	static void mostrarTemperatura(TemperaturasService service) {
		
		Ciudad[] ciudades = service.devolverCiudades();
		
		for (Ciudad elemento : ciudades) {
			System.out.println(elemento.getNombre() + " " + elemento.getTemperatura());
		}
	}

}
