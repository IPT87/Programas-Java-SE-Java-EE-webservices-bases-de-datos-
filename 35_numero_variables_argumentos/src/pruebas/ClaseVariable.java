package pruebas;

public class ClaseVariable {
	
	public void mostrar(String... datos) {

	}

	public void mostrar2(String texto, int... nums) {

	}

	// error
	/*
	 * public void mostrar3(int...datos, long l) {
	 * 
	 * }
	 */

}

class Prueba {
	
	void test() {
		ClaseVariable c = new ClaseVariable();

		c.mostrar();
		c.mostrar("hola");
		c.mostrar("hola", "que", "tal");
		c.mostrar(new String[3]);
		c.mostrar2("hello", 3, 7, 1);
	}
	
}
