package principal;

import java.util.HashMap;

import model.Persona;

public class Test6 {
	
	public static void main(String[] args) {

	HashMap<String, Persona> listaPersonas = new HashMap<>();
	
	listaPersonas.put("bn3", new Persona("Juan","alfd@gg.com",55555,20));
	listaPersonas.put("qw43", new Persona("Elena","al@gg.gob",42332,17));
	listaPersonas.put("9iud", new Persona("Marta","alaaoi@gg.org",121,34));
	listaPersonas.put("rrk8", new Persona("Lucas","alert@gg.es",6667,16));
	listaPersonas.put("xc6", new Persona("Alicia","sdfl@gg.com",2121,35));
	
	listaPersonas.forEach((k, v) -> System.out.println(k + ":" + v.getNombre()));
	listaPersonas.replaceAll((k, v) -> k.length() > 3
			? new Persona(v.getNombre(), v.getEmail(), v.getTelefono(), v.getEdad() + 10)
			: new Persona(v.getNombre(), v.getEmail(), v.getTelefono(), v.getEdad()));
	listaPersonas.compute("bn3", (k ,v) -> v.getNombre().equals("Juan") 
			? new Persona("Samuel", v.getEmail(), v.getTelefono(), v.getEdad())
			: new Persona(v.getNombre(), v.getEmail(), v.getTelefono(), v.getEdad()));
	listaPersonas.forEach((k, v) -> System.out.println(k + ":" + v.getNombre()));
	listaPersonas.computeIfAbsent("bn4", p -> new Persona("Dimitar", "ahmat77@gmail.com", 657894801, 43));
	listaPersonas.forEach((k, v) -> System.out.println(k + ":" + v.getNombre()));
	}
}
