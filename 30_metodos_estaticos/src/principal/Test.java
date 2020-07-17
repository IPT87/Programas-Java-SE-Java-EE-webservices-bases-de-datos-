package principal;

interface Inter1 {
	static void otro() {
		System.out.println("Estatico de interfaz");
	}
}

class Clase1 {
	public static void met() {
		System.out.println("Estatico de Clase1");
	}
	
	public void mensaje() {
		System.out.println("Hola");
	}
}

class Clase2 extends Clase1 implements Inter1 {
	
}

public class Test {

	public static void main(String[] args) {
		Clase1 c1 = new Clase2();
		c1.met(); // esel propio metodo de la clase 1 (static)
		c1.mensaje(); // metodo del objeto
		Clase2.met(); // se puede
		// Clase2.otro(); // no es posible
	}

}
