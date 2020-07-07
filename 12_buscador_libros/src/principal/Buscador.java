package principal;

import java.util.Scanner;

public class Buscador {

	public static void main(String[] args) {
		
		String titulos="La biblia de Java, Python básico, Angular en un día, programación Web con Java EE, Spring Boot, Fundamentos de Python, Java y Spring, la biblia de php";
		String[] listaDeTitulos = titulos.split(",");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce palabra:");
		String palabra = scan.nextLine();
		scan.close();
		
		for (String elemento : listaDeTitulos) {
			if (elemento.toLowerCase().contains(palabra.toLowerCase())) {
				System.out.println(elemento.trim());
			}
		}


	}

}
