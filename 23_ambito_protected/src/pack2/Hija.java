package pack2;

import pack1.Padre;

public class Hija extends Padre {
	public void otroMetodo() {
		this.metodo();
	}
	
	public void masMetodos() {
		Padre p1 = new Padre();
		// p1.metodo(); // no visible
	}	
}
