package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFichero {

	public static void main(String[] args) {
		String ruta = "C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\Test\\pruebas.txt";
		try (FileReader fr = new FileReader(ruta);
			BufferedReader bfr = new BufferedReader(fr)) {
			
			String linea = bfr.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = bfr.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
