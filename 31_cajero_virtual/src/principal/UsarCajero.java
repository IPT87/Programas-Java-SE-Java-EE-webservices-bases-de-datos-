package principal;

import java.util.Scanner;

import service.CajeroVirtualService;

public class UsarCajero {
	static Scanner scan = new Scanner(System.in);
	static CajeroVirtualService service = new CajeroVirtualService();
	
	public static void main(String[] args) {
		System.out.println("Introduce numero de cuenta:");
		int numeroCuenta = Integer.parseInt(scan.nextLine());
		int opcion = 0;
		
		if (verificarCuenta(numeroCuenta)) {
			do {
				menu();
				opcion = Integer.parseInt(scan.nextLine());

				switch (opcion) {
				case 1:
					extraer(numeroCuenta);
					break;
				case 2:
					ingresar(numeroCuenta);
					break;
				case 3:
					ultimosMovimientos(numeroCuenta);
					break;
				case 4:
					transferencia(numeroCuenta);
					break;
				}

			} while (opcion != 5);
		} else {
			System.out.println("La cuenta no existe.");
		}

		scan.close();
	}
	
	public static boolean verificarCuenta(int numeroCuenta) {
		return service.validarCuenta(numeroCuenta);
	}
	
	public static void menu() {
		System.out.println("--------Opciones--------");
		System.out.println("1. Sacar dinero.");
		System.out.println("2. Ingresar dinero.");
		System.out.println("3. Mostrar saldo y ultimos movimientos.");
		System.out.println("4. Realizar transferencia.");
		System.out.println("5. Salir");
	}
	
	public static void extraer(int numeroCuenta) {
		System.out.println("Introduce cantidad:");
		int cantidad = Integer.parseInt(scan.nextLine());
		
		if (service.extraerDinero(cantidad, numeroCuenta)) {
			System.out.println("Usted ha retirado " + cantidad + "€.");
		} else {
			System.out.println("No hay suficiente dinero en la cuenta para realizar la operacion!");
		}
	}
	
	public static void ingresar(int numeroCuenta) {
		System.out.println("Introduce cantidad:");
		int cantidad = Integer.parseInt(scan.nextLine());
		
		if (service.ingresarDinero(cantidad, numeroCuenta)) {
			System.out.println("Usted ha ingresado " + cantidad + "€.");
		} else {
			System.out.println("Ha ocurrido un error. No se ha podido ingresar el dinero en la cuenta!");
		}
	}
	
	public static void ultimosMovimientos(int numeroCuenta) {
		service.mostrarSaldoMovimientos(numeroCuenta);
	}
	
	public static void transferencia(int numeroCuenta) {
		System.out.println("Introduce cantidad:");
		int cantidad = Integer.parseInt(scan.nextLine());
		
		System.out.println("Introduce el numero de la cuenta beneficiaria:");
		int cuentaDestino = Integer.parseInt(scan.nextLine());
		
		if(service.realizarTransferencia(cantidad, numeroCuenta, cuentaDestino)) {
			System.out.println("Transferencia realizda con exito.");
		} else {
			System.out.println("Ha ocurrido un error. No se ha podido realizar la transferencia.");
		}
	}

}
