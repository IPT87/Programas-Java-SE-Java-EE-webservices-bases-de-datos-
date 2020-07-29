package principal;

import java.util.Scanner;

import model.Contacto;
import service.ContactoService;

public class ManipularBd {
	static Scanner scan = new Scanner(System.in);
	static ContactoService service = new ContactoService();
	
	public static void main(String[] args) {
		int opcion = 0;
		
		do {
			menu();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case 1:
				altaContacto();
				break;
			}
			
		} while (opcion != 2);

		scan.close();
	}
	
	private static void menu() {
		System.out.println("------OPCIONES------");
		System.out.println("1. Alta de ontacto.");
		System.out.println("2. Salir.");
	}
	
	private static Contacto altaContacto() {
		System.out.println("Introduce nombre: ");
		String nombre = scan.nextLine();
		System.out.println("Introduce email: ");
		String email = scan.nextLine();
		System.out.println("Introduce edad: ");
		int edad = Integer.parseInt(scan.nextLine());
		
		Contacto contacto = new Contacto(nombre, email, edad);
		
		if(service.addContacto(contacto)) {
			System.out.println("Contacto añadido.");
		} else {
			System.out.println("Error.");
		}
		
		return contacto;
	}

}
