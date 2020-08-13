package principal;

import java.util.Scanner;

import service.AdministradoresService;

public class Administrar {
	static Scanner scan = new Scanner(System.in);
	static AdministradoresService service = new AdministradoresService();
	
	public static void main(String[] args) {
		int opcion = 0;

		do {
			menu();
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case 1:
				addNuevoClienteCuenta();
				break;
			case 2:
				addNuevoTitularCuenta();
				break;
			}

		} while (opcion != 3);
		
		scan.close();
	}
	
	public static void menu() {
		System.out.println("--------Opciones--------");
		System.out.println("1. Añadir nuevo cliente y cuenta.");
		System.out.println("2. Añadir nuevo titular de cuenta existente.");
		System.out.println("3. Salir");
	}
	
	public static void addNuevoClienteCuenta() {
		System.out.println("Introduce numero de cuenta:");
		int numeroCuenta = Integer.parseInt(scan.nextLine());
		
		if(!service.comprobarCuenta(numeroCuenta)) {
			System.out.println("Introduce el DNI del titular de la cuenta:");
			int dni = Integer.parseInt(scan.nextLine());
			
			if(!service.comprobarDni(dni)) {
				System.out.println("Introduce el nombre del titular:");
				String nombre = scan.nextLine();
				System.out.println("Introduce la direccion del titular:");
				String direccion = scan.nextLine();
				System.out.println("Introduce el numero de telefono del titular:");
				int telefono = Integer.parseInt(scan.nextLine());
				System.out.println("Introduce saldo:");
				double saldo = Double.parseDouble(scan.nextLine());
				System.out.println("Introduce el tipo de la cuenta:");
				String tipoCuenta = scan.nextLine();
				
				service.addNuevoTitular(numeroCuenta, saldo, tipoCuenta, dni, nombre, direccion, telefono);
				System.out.println("El nuevo cliente y cuenta añadidos con exito.");
			} else {
				System.out.println("El DNI ya existe en la base de datos!");
			}
		} else {
			System.out.println("La cuenta ya existe en la base de datos!");
		}
	}
	
	public static void addNuevoTitularCuenta() {
		System.out.println("Introduce numero de cuenta:");
		int numeroCuenta = Integer.parseInt(scan.nextLine());
		
		if(service.comprobarCuenta(numeroCuenta)) {
			System.out.println("Introduce el DNI del titular de la cuenta:");
			int dni = Integer.parseInt(scan.nextLine());
			
			if(!service.comprobarDni(dni)) {
				System.out.println("Introduce el nombre del titular:");
				String nombre = scan.nextLine();
				System.out.println("Introduce la direccion del titular:");
				String direccion = scan.nextLine();
				System.out.println("Introduce el numero de telefono del titular:");
				int telefono = Integer.parseInt(scan.nextLine());
				
				service.addTitularCuentaExistente(numeroCuenta, dni, nombre, direccion, telefono);
				System.out.println("Nuevo titular de la cuenta " + numeroCuenta + " añadido con exito.");
			} else {
				System.out.println("El DNI ya existe en la base de datos!");
			}
		} else {
			System.out.println("La cuenta no existe en la base de datos!");
		}
	}

}
