package principal;

import java.util.Arrays;
import java.util.List;

import model.Persona;

public class Test5 {

	public static void main(String[] args) {
		List<Persona> varias = Arrays.asList(new Persona("Alex","al@gg.com",55554,21),				
				new Persona("Juan","alfd@gg.com",55555,20),
				new Persona("Elena","al@gg.gob",42332,17),
				new Persona("Marta","alaaoi@gg.org",121,34),
				new Persona("Lucas","alert@gg.es",6667,16),
				new Persona("Alicia","sdfl@gg.com",2121,35));
		
		varias.sort((p1, p2) -> p1.getEdad() - p2.getEdad());
		//Collections.sort(varias, (p1,p2)->p1.getEdad()-p2.getEdad());
		varias.forEach(p -> System.out.println(p.getNombre()));
		
	}

}
