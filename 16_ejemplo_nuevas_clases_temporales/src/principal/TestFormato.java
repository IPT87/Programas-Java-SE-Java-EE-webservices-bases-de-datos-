package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestFormato {

	public static void main(String[] args) {
		//formatear fecha en texto
		LocalDate fecha = LocalDate.of(2010, 11, 24);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(fecha.format(dtf));
		//parsear texto en fecha
		String miFecha = "30/08/2012";
		LocalDate nFecha = LocalDate.parse(miFecha, dtf);
		System.out.println(nFecha);
	}

}
