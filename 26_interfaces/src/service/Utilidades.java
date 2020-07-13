package service;

public class Utilidades {
	
	public void generador(Item item) {
		if (item.activo()) {
			item.procesar();
		}
	}
	
}
