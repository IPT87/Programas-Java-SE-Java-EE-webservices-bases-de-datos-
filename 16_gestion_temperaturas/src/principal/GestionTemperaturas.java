package principal;

import java.util.ArrayList;
import java.util.Scanner;
import model.Ciudad;

public class GestionTemperaturas {

	public static void main(String[] args) {

		ArrayList<Ciudad> datos = new ArrayList<>();
		String opcion;
		boolean salir = false;

		do {

			Scanner scan = new Scanner(System.in);

			menu();

			opcion = scan.nextLine();

			switch (opcion) {
			case "1":
				addTemperatura(datos);
				break;
			case "2":
				tempMedia(datos);
				break;
			case "3":
				tempExtremas(datos);
				break;
			case "4":
				mostrarTodasTemperaturas(datos);
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

	static void addTemperatura(ArrayList<Ciudad> temperaturas) {
		existeCiudad(temperaturas);
	}

	static void tempMedia(ArrayList<Ciudad> temperaturas) {

		double tempMedia = 0;

		for (Ciudad elemento : temperaturas) {

			tempMedia += elemento.getTemperatura();
		}

		System.out.println("La temperatura media es de " + (tempMedia / temperaturas.size() + " grados."));
		System.out.println();
	}

	static void tempExtremas(ArrayList<Ciudad> temperaturas) {

		double min = temperaturas.get(0).getTemperatura();
		double max = temperaturas.get(0).getTemperatura();
		String ciudadTempMin = "";
		String ciudadTempMax = "";

		for (Ciudad elemento : temperaturas) {

			if (elemento.getTemperatura() < min) {

				min = elemento.getTemperatura();
				ciudadTempMin = elemento.getNombre();
			}

			if (elemento.getTemperatura() > max) {

				max = elemento.getTemperatura();
				ciudadTempMax = elemento.getNombre();
			}
		}

		System.out.println("La temperatura minima es de " + min + " grados, en " + ciudadTempMin + ".");
		System.out.println("La temperatura maxima es de " + max + " grados, en " + ciudadTempMax + ".");
		System.out.println();
	}

	static void mostrarTodasTemperaturas(ArrayList<Ciudad> temperaturas) {

		for (Ciudad element : temperaturas) {
			System.out.println(
					"En " + element.getNombre() + " la temperatura es de " + element.getTemperatura() + " grados.");
		}

		System.out.println();
	}

	static boolean existeCiudad(ArrayList<Ciudad> temperaturas) {

		Ciudad ciudad = new Ciudad();
		Scanner sc = new Scanner(System.in);
		String nombreCiudad;
		
		System.out.println("Introduce el nombre de la ciudad: ");
		nombreCiudad = sc.nextLine();

		for (Ciudad elemento : temperaturas) {

			if (!elemento.getNombre().equals(nombreCiudad)) {

				System.out.println("La ciudad ya existe en la lista.");

				ciudad.setNombre(nombreCiudad);
				System.out.println("Introduce la temperatura: ");
				ciudad.setTemperatura(Double.parseDouble(sc.nextLine()));

				temperaturas.add(ciudad);
				
				return true;
			} else {
				
				return false;
			}
		}
		
		return true;
	}

}
