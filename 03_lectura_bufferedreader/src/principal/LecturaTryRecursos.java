package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LecturaTryRecursos {

	public static void main(String[] args) {
		
		try(InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader bfr = new BufferedReader(isr);) {
			System.out.println("Introduce tu nombre: ");
			String nombre = bfr.readLine();
			System.out.println("Te llamas " + nombre);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
