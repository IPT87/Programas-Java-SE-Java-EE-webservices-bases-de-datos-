package principal;

import java.util.HashSet;
import model.Contacto;

public class Test {

	public static void main(String[] args) {
		HashSet<Contacto> contactos = new HashSet<>();
		contactos.add(new Contacto("Juan", "juan79@gmail.com", 768_693_231));
		contactos.add(new Contacto("David", "davidg85@gmail.com", 734_710_716));
		contactos.add(new Contacto("Juan", "juan79@gmail.com", 768_693_231));
		
		for (Contacto contacto : contactos) {
			System.out.println("Nombre " + contacto.getNombre() + ", email " + contacto.getEmail() + ", telefono " + contacto.getTelefono() + ".");
		}

	}

}
