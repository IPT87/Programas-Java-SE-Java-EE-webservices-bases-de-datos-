package principal;

import java.util.Scanner;

public class OperaNumeros {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numerador, denominador, resultado;
		
		try {
			System.out.println("Introduce numerador: ");
			numerador = Integer.parseInt(scanner.nextLine());
			System.out.println("Introduce denominador: ");
			denominador = Integer.parseInt(scanner.nextLine());
			resultado = numerador / denominador;
			System.out.println("La division es " + resultado);
		} 
		catch(NumberFormatException | ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			System.out.println("Programa finalizado.");
			scanner.close();
		}
		
	}

}
