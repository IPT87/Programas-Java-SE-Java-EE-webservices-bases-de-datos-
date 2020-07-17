package principal;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Escritura {

	public static void main(String[] args) {
		String ruta = "C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\Test\\pruebas.txt";

		try(PrintStream out = new PrintStream(ruta);) {
			out.println("Es la linea 1");
			out.println(4500);
			out.println("fin del texto");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}

}
