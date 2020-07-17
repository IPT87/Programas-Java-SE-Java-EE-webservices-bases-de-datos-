package principal;

import java.util.Scanner;

import service.NotasService;

public class Notas {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		NotasService service = new NotasService();
		int opcion;
		
		do {
			menu();
			opcion = Integer.parseInt(scanner.nextLine());
			
			switch (opcion) {
			case 1:
				System.out.println("Introduce nota:");
				double nota = Double.parseDouble(scanner.nextLine());
				service.addNota(nota);
				break;
			case 2:
				System.out.println("Nota media: " + service.media());
				break;
			case 3:
				System.out.println("Aprobados: " + service.totalAprobados());
				break;
			case 4:
				service.mostrarNotas().forEach(n -> System.out.println(n));
				break;
			}
		} while(opcion != 5);
		
		scanner.close();
	}
	
	private static void menu() {
		System.out.println("1. Nueva nota");
		System.out.println("2. Media");
		System.out.println("3. Total aprobados");
		System.out.println("4. Mostrar notas");
		System.out.println("5. Salir");
	}

}
