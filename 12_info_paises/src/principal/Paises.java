package principal;

import java.util.List;
import java.util.Map;

import model.Pais;
import service.ServicePaises;

public class Paises {

	public static void main(String[] args) {
		ServicePaises service = new ServicePaises();

		imprimirDatos(service);
	}
	
	private static void imprimirDatos(ServicePaises service) {
		System.out.println("Paises con mas de 180 000 000 habitantes en la lista: " + service.paisesMasHabitantesValor(180_000_000) + ".");
		System.out.println();
		
		System.out.println("La temperatura media entre todos los paises en la lista es: " + service.temperaturaMediaPaises() + " grados.");
		System.out.println();
		
		System.out.println("Existen paises en la lista con menos de 90 000 000 habitantes, fundados antes del año 1830?");
		if (service.algunPaisCondicion(90_000_000, 1830)) {
			System.out.println("Si.");
		} else {
			System.out.println("No.");
		}
		System.out.println();
		
		System.out.println("El pais mas poblado de la lista es: " + service.paisMasPoblado().getNombre() + ".");
		System.out.println();
		
		System.out.println("Existen paises en la lista fundados antes del año 1755?");
		List<Pais> paises = service.paisesFundacionAnterior(1755);
		if (paises != null) {
			paises.forEach(p -> System.out.println(p.getNombre()));
		} else {
			System.out.println("No.");
		}
		System.out.println();
		
		System.out.println("El continente con mas paises que aparecen en la lista es: " + service.continenteConMasPaises() + ".");
		System.out.println();
		
		Map<String, List<Pais>> paisesPorContinente = service.paisesPorContinente();
		paisesPorContinente.forEach((k, p) -> System.out.println("Continente: " + k + " - " + p));
	}

}
