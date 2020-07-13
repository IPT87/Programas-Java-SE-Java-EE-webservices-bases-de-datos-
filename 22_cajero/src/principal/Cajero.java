package principal;

import java.util.ArrayList;
import java.util.Scanner;

import model.Movimiento;
import service.CuentaServiceMovimiento;

public class Cajero {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce saldo inicial: ");
		double saldoInicial = Double.parseDouble(scan.nextLine());
		System.out.println("Introduce limite: ");
		double limite = Double.parseDouble(scan.nextLine());
		CuentaServiceMovimiento service = new CuentaServiceMovimiento(saldoInicial, limite);
		String opcion;
		
		do {
			menu();
			opcion = scan.nextLine();
			
			switch (opcion) {
			case "1":
				System.out.println("Introduce cantidad: ");
				service.ingresar(Double.parseDouble(scan.nextLine()));
				break;
			case "2":
				System.out.println("Introduce cantidad: ");
				service.extraer(Double.parseDouble(scan.nextLine()));
				break;
			case "3":
				ArrayList<Movimiento> lista = new ArrayList<>();
				lista = service.getLista();
				for (Movimiento elemento : lista) {
					System.out.println(elemento);
				}
				System.out.println("Saldo actual - " + service.getSaldo());
				break;
			}
		} while (!opcion.equals("4"));

	}
	
	static void menu() {
		System.out.println("--------Opciones--------");
		System.out.println("1. Ingresar");
		System.out.println("2. Extraer");
		System.out.println("3. Consulta de movimientos y saldo");
		System.out.println("4. Salir");
	}

}
