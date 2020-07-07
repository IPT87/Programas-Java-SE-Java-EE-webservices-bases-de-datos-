package principal;

public class Factura {

	public static void main(String[] args) {
		double pProducto = 6.2;
		int unidades = 6;
		
		double pTotal = (unidades > 5) ? pProducto * unidades * 0.10 : pProducto * unidades;
		
		System.out.println("El precio total: " + pTotal);

	}

}
