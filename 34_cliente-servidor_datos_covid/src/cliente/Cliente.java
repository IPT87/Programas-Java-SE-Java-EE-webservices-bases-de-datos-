package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import service.GuardarCasoService;

public class Cliente {
	private static GuardarCasoService service = new GuardarCasoService();

	public static void main(String[] args) {
		try (Socket sc = new Socket("localhost", 8000); 
				Scanner scan = new Scanner(System.in);) {
			PrintStream out = new PrintStream(sc.getOutputStream());
			System.out.println("Introduce nombre de comunidad:");
			String entradaTexto;
			entradaTexto = scan.nextLine();
			out.println(entradaTexto);
			BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			String c = bf.readLine();
			service.agregarCaso(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
