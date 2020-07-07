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

		Scanner sc = new Scanner(System.in);
		Ciudad ciudad = new Ciudad();

		System.out.println("Introduce el nombre de la ciudad: ");
		ciudad.setNombre(sc.nextLine());

		System.out.println("Introduce la temperatura: ");
		ciudad.setTemperatura(Double.parseDouble(sc.nextLine()));

		temperaturas.add(ciudad);

	}

	static void tempMedia(ArrayList<Ciudad> temperaturas) {

		double tempMedia = 0;

		for (int i = 0; i < temperaturas.size(); i++) {

			tempMedia += temperaturas.get(i).getTemperatura();
		}

		System.out.println("La temperatura media es de " + (tempMedia / temperaturas.size() + " grados."));

		System.out.println();

	}

	static void tempExtremas(ArrayList<Ciudad> temperaturas) {

		double min = temperaturas.get(0).getTemperatura();
		double max = temperaturas.get(0).getTemperatura();
		String ciudadTempMin = "";
		String ciudadTempMax = "";

		for (int i = 0; i < temperaturas.size(); i++) {

			if (temperaturas.get(i).getTemperatura() < min) {

				min = temperaturas.get(i).getTemperatura();
				ciudadTempMin = temperaturas.get(i).getNombre();
			}

			if (temperaturas.get(i).getTemperatura() > max) {

				max = temperaturas.get(i).getTemperatura();
				ciudadTempMax = temperaturas.get(i).getNombre();
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

}
