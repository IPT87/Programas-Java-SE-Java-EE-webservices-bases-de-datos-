package service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardarCasoService {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private final String RUTA = "ruta del fichero texto en el que guardamos los datos de la resuesta del servidor";
	private final String SEPARADOR = ",";
	
	public boolean agregarCaso(String texto) {
		if (!existeCaso(texto)) {
			try (PrintStream ps = new PrintStream(new FileOutputStream(RUTA, true))) {
				ps.println(texto);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private boolean existeCaso(String texto) {
		try (BufferedReader bf = new BufferedReader(new FileReader(RUTA))) {
			String linea;
			while ((linea = bf.readLine()) != null) {
				String[] datosFichero = linea.split(SEPARADOR);
				String[] nuevosDatos = texto.split(SEPARADOR);
				String nombreComunidad = datosFichero[0];
				Date fecha = sdf.parse(datosFichero[3].substring(datosFichero[3].length() - 11, datosFichero[3].length() - 1));
				if (nombreComunidad.equals(nuevosDatos[0]) && sdf.parse(nuevosDatos[3].substring(datosFichero[3].length() - 11, datosFichero[3].length() - 1)).compareTo(fecha) == 0) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
}
