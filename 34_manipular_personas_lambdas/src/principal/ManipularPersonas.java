package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import model.Persona;
import servicio.PersonasService;

public class ManipularPersonas {

	public static void main(String[] args) {
		List<Persona> varias = Arrays.asList(new Persona("Alex","al@gg.com",55554,21),				
				new Persona("Juan","alfd@gg.com",55555,20),
				new Persona("Elena","al@gg.gob",42332,17),
				new Persona("Marta","alaaoi@gg.org",121,34),
				new Persona("Lucas","alert@gg.es",6667,16),
				new Persona("Alicia","sdfl@gg.com",2121,35));


		PersonasService service = new PersonasService();
		
		// imprime todas las personas de la lista mayores de edad
		service.imprimir(varias, persona -> persona.getEdad() >= 18);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduce dominio: ");
		String dominio = scanner.nextLine();
		
		// imprime todas las personas de la lista con email que termina con un dominio especificado
		service.imprimir(varias, persona -> persona.getEmail().endsWith(dominio));
		
		System.out.println("Introduce telefono: ");
		int telefono = Integer.parseInt(scanner.nextLine());
		
		// imprime todas las personas de la lista con un telefono igual al introducido
		service.imprimir(varias, persona -> persona.getTelefono() < telefono);
		
		// imprime los nomres de todas las personas de la lista con una edad de entre 20 y 40 años
		service.imprimir(varias, persona -> persona.getEdad() >= 20 && persona.getEdad() <= 40, persona -> persona.getNombre());
		
		// imprime los nombres de todas las personas de la lista que empiezan con la letra "A"
		service.procesar(varias, persona -> persona.getNombre().startsWith("A"), persona -> System.out.println(persona.getNombre()));
		
		scanner.close();
	}

}
