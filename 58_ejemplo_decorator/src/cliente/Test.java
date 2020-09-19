package cliente;

import patron.decorator.DecoradorDisco;
import patron.decorator.OrdenadorBase;
import patron.decorator.OrdenadorEstandar;

public class Test {

	public static void main(String[] args) {
		OrdenadorBase ordenador=new OrdenadorEstandar();
		System.out.println("Sin decorar "+ordenador.getDescripcion());
		System.out.println("Sin decorar "+ordenador.getPrecio());
		//modifica el componente aplicando un decorador
		ordenador=new DecoradorDisco(ordenador);
		System.out.println("Decorado "+ordenador.getDescripcion());
		System.out.println("Decorado "+ordenador.getPrecio());
	}

}
