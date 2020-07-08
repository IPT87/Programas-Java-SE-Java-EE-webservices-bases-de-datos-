package principal;

import java.util.Scanner;
import model.Contacto;
import service.ContactosService;

public class ListaContactos {

	public static void main(String[] args) {

		ContactosService service = new ContactosService();
		String opcion;
		boolean salir = false;

		do {

			Scanner scan = new Scanner(System.in);

			menu();

			opcion = scan.nextLine();

			switch (opcion) {
			case "1":
				altaContacto(service);
				break;
			case "2":
				System.out.println("Introduce email: ");
				String email = scan.nextLine();
				if (service.buscarContacto(email) != null) {
					Contacto persona = service.buscarContacto(email);
					System.out.println("Nombre " + persona.getNombre() + ", email " + persona.getEmail() + ", telefono "
							+ persona.getTelefono() + ".");
				} else {
					System.out.println("El contacto no existe.");
				}
				break;
			case "3":
				System.out.println("Introduce email: ");
				String borrar = scan.nextLine();

				if (service.eliminarContacto(borrar)) {
					System.out.println("El contacto con email " + borrar + " eliminado con exito.");
				} else {
					System.out.println("El contacto no existe.");
				}
				break;
			case "4":
				for (Contacto elemento : service.verTodos()) {
					System.out.println("Nombre " + elemento.getNombre() + ", email " + elemento.getEmail()
							+ ", telefono " + elemento.getTelefono() + ".");
				}
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
		System.out.println("1. Nuevo contacto");
		System.out.println("2. Buscar contacto");
		System.out.println("3. Eliminar contacto");
		System.out.println("4. Ver todos");
		System.out.println("5. Salir");
		System.out.println();
		System.out.println("Elige opcion: ");
	}

	static void altaContacto(ContactosService service) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Telefono: ");
		int telefono = Integer.parseInt(sc.nextLine());
		System.out.println("Email: ");
		String email = sc.nextLine();

		Contacto contacto = new Contacto(nombre, email, telefono);

		if (service.addContacto(contacto)) {
			System.out.println("Contacto añadido.");
		} else {
			System.out.println("El contacto ya existe, prueba otra opcion.");
		}
	}

}
