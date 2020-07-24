package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Caso;

public class Utilidades {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Caso construirCaso(String cadena, String separador) {
		String[] datos = cadena.split(separador);

		try {
			return new Caso(datos[0], sdf.parse(datos[1]), Integer.parseInt(datos[2]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
