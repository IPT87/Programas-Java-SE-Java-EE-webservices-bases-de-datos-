package principal;

import java.util.Scanner;

public class Buscador {

	static StringBuilder titulos = new StringBuilder("");
	static Scanner scan = new Scanner(System.in);
	static String opcion;

	public static void main(String[] args) {

		do {
			printMenu();

			opcion = scan.nextLine();

			switch (opcion) {
			case "1":
				addTitulos();
				break;
			case "2":
				buscarTitulos();
				break;
			case "3":
				eliminarTitulo();
				break;
			case "4":
				System.out.println("Hasta luego!");
				break;
			default:
				System.out.println("Opcion incorrecta...");
			}
		} while (!opcion.equals("4"));

		scan.close();

	}

	static void printMenu() {

		System.out.println("1. Añadir nuevo titulo");
		System.out.println("2. Buscar titulos");
		System.out.println("3. Eliminar titulo");
		System.out.println("4. Salir");
		System.out.println();
		System.out.println("Introduce opcion:");
	}

	static void addTitulos() {

		System.out.println("Introduce titulo: ");

		String texto = scan.nextLine();

		if (!texto.isEmpty()) {
			titulos.append(texto + ",");
		}
	}

	static void buscarTitulos() {

		System.out.println("Introduce palabra de busqueda: ");

		String[] catologo = titulos.toString().split(",");

		String titulo = scan.nextLine();
		
		boolean tituloEncontrado = false;

		for (String element : catologo) {
			if (element.equalsIgnoreCase(titulo)) {
				System.out.println("Titulo encontrado: *" + element + "*");
				tituloEncontrado = true;
				break;
			}
		}

		if (!tituloEncontrado) {
			
			System.out.println("Titulo *" + titulo + "* no encontrado en la libreria.");
		}
	}

	static void eliminarTitulo() {

		System.out.println("Introduce elemento para eliminar: ");

		String titulo = scan.nextLine() + ",";

		int index = titulos.indexOf(titulo);

		if (index != -1) {
			titulos.delete(index, index + titulo.length());
			System.out.println("El titulo *" + titulo + "* se ha eliminado.");
		} else {
			System.out.println("El titulo *" + titulo + "* no existe en la libreria.");
		}

	}

}
