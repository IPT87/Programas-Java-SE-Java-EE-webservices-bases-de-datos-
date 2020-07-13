package principal;

import auxiliares.Operaciones;
import geometria.Circulo;
import objetos.Mesa;

public class PruebasOperaciones {

	public static void main(String[] args) {
		operarObjetos(new Circulo("naranja", 4));
		operarObjetos(new Mesa(10, 9));

	}
	
	public static void operarObjetos(Operaciones oper) {
		oper.girar(100);
		oper.invertir();
	}

}
