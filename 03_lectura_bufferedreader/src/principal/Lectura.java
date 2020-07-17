package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lectura {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bfr = null;
		
		try {
			System.out.println("Introduce tu nombre: ");
			bfr = new BufferedReader(isr);
			String nombre = bfr.readLine();
			System.out.println("Te llamas " + nombre);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bfr != null) {
					bfr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
