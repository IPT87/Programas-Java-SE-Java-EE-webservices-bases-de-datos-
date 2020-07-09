package principal;

import service.Punto3d;

public class Test {

	public static void main(String[] args) {

		Punto3d p3d = new Punto3d();
		p3d.imprimir();
		p3d.desplazar(5);
		p3d.imprimir();
	}

}
