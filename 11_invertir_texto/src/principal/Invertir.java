package principal;

import java.util.Scanner;

public class Invertir {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String texto, textoFinal = "";
		System.out.println("Introduce un texto: ");
		texto = scan.nextLine();
		scan.close();
		
		for (int i = texto.length() - 1; i >= 0; i--) {
			textoFinal += texto.charAt(i);
			// System.out.print(texto.charAt(i));
		}
		
		System.out.println(textoFinal);
		
	}

}
