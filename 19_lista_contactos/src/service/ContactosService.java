package service;

import java.util.Collection;
import java.util.HashMap;
import model.Contacto;

public class ContactosService {

	private HashMap<String, Contacto> persona;

	public ContactosService() {
		persona = new HashMap<>();
	}

	public boolean addContacto(Contacto contacto) {
		if (!persona.containsKey(contacto.getEmail())) {
			persona.put(contacto.getEmail(), contacto);
			return true;
		}

		return false;
	}

	public Contacto buscarContacto(String clave) {
		
		Contacto contacto = persona.get(clave);

		/*if (persona.containsKey(clave)) {
			return persona.get(clave);
		} else {
			return null;
		}*/
		
		if(contacto != null) {
			return new Contacto(contacto.getNombre(), contacto.getEmail(), contacto.getTelefono());
		}
		return null;
	}

	public boolean eliminarContacto(String email) {
		if (persona.containsKey(email)) {
			persona.remove(email);
			return true;
		}

		return false;
	}

	public Contacto[] verTodos() {
		Collection<Contacto> contactos = persona.values();
		
		Contacto[] nuevosContactos = new Contacto[contactos.size()];
		
		int i = 0;
		for(Contacto c : contactos) {
			nuevosContactos[i] = new Contacto(c.getNombre(), c.getEmail(), c.getTelefono());
			i++;
		}
		
		//return contactos.toArray(new Contacto[0]);
		return nuevosContactos;
	}
}
