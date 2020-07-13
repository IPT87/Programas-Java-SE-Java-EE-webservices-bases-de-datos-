package principal;

import implementaciones.Ciudad;
import implementaciones.Punto;
import service.Utilidades;

public class Presentacion {

	public static void main(String[] args) {
		Utilidades util = new Utilidades();
		Ciudad ciudad = new Ciudad();
		ciudad.setNombre("Madrid");
		ciudad.setTemperatura(29.3);
		Punto punto = new Punto(5, 5);
		
		util.generador(ciudad);
		util.generador(punto);

	}

}
