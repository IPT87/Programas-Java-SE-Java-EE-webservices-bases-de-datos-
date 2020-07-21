package principal;

import service.PersonasService;

public class TestFront {

	public static void main(String[] args) {
		PersonasService service = new PersonasService();
		service.personasAgrupadasPorDominio()
		.forEach((k, v) -> {
			System.out.println("Dominio " + k + " : ");
			v.forEach(p -> System.out.println(p.getNombre()));
		});

	}

}
