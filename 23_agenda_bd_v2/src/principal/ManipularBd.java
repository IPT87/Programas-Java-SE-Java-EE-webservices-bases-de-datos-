package principal;

import java.util.List;
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
			case 2:
				eliminarContacto();
				break;
			case 3:
				buscaContacto();
				break;
			case 4:
				muestraContactos();
				break;
			}

		} while (opcion != 5);

		scan.close();
	}

	private static void menu() {
		System.out.println("--------OPCIONES--------");
		System.out.println("1. Alta de ontacto");
		System.out.println("2. Eliminar contacto");
		System.out.println("3. Buscar contacto");
		System.out.println("4. Mostrar contactos");
		System.out.println("5. Salir");
	}

	private static Contacto altaContacto() {
		System.out.println("Introduce nombre: ");
		String nombre = scan.nextLine();
		System.out.println("Introduce email: ");
		String email = scan.nextLine();
		System.out.println("Introduce edad: ");
		int edad = Integer.parseInt(scan.nextLine());

		Contacto contacto = new Contacto(nombre, email, edad);

		if (service.addContacto(contacto)) {
			System.out.println("Contacto añadido.");
		} else {
			System.out.println("Error.");
		}

		return contacto;
	}

	private static void eliminarContacto() {
		System.out.println("Introduce email: ");
		String email = scan.nextLine();

		if (service.eliminarContacto(email)) {
			System.out.println("Contacto eliminado.");
		} else {
			System.out.println("Error.");
		}
	}

	private static void buscaContacto() {
		System.out.println("Introduce email: ");
		String email = scan.nextLine();
		Contacto contacto = service.buscarContacto(email);

		if (contacto != null) {
			System.out.println(contacto.getNombre() + ", " + contacto.getEmail() + ", " + contacto.getEdad());
		}
	}

	public static void muestraContactos() {
		List<Contacto> lista = service.mostrarContactos();

		lista.forEach(c -> System.out.println(c.getNombre() + ", " + c.getEmail() + ", " + c.getEdad()));
	}

}
