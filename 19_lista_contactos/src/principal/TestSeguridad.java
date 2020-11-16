package principal;

import model.Contacto;
import service.ContactosService;

public class TestSeguridad {

	public static void main(String[] args) {
		ContactosService service = new ContactosService();
		service.addContacto(new Contacto("c1", "e1", 11));
		service.addContacto(new Contacto("c2", "e2", 22));
		service.addContacto(new Contacto("c3", "e3", 33));
		
		Contacto[] todos = service.verTodos();
		
		for(Contacto c : todos) {
			c.setNombre("hacker");
		}
		
		Contacto[] otros = service.verTodos();
		for (Contacto c : otros) {
			System.out.println(c.getNombre());
		}
		
	}

}
