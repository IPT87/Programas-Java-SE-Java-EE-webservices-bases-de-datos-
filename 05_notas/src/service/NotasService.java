package service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class NotasService {
	private String ruta = "C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\Test\\notas.txt";

	public boolean addNota(double nota) {
		try (FileOutputStream fout = new FileOutputStream(ruta, true); PrintStream out = new PrintStream(fout);) {
			out.println(nota);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public double media() {
		double media = 0.0;

		for (Double nota : mostrarNotas()) {
			media += nota;
		}

		if (media != 0) {
			return media / mostrarNotas().size();
		} else {
			return media;
		}
	}

	public int totalAprobados() {
		int aprobados = 0;

		for (Double nota : mostrarNotas()) {
			if (nota > 5.0) {
				aprobados++;
			}
		}

		return aprobados;
	}

	public List<Double> mostrarNotas() {
		List<Double> lista = new ArrayList<>();

		try (FileReader fr = new FileReader(ruta); BufferedReader bfr = new BufferedReader(fr)) {

			String linea = bfr.readLine();
			while (linea != null) {
				try {
					lista.add(Double.parseDouble(linea));
				} catch (NumberFormatException e) {
					lista.add(0.0);
				}
				linea = bfr.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
