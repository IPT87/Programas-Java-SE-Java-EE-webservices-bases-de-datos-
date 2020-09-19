package patron.decorator;

public class OrdenadorEstandar implements OrdenadorBase{

	@Override
	public String getDescripcion() {
		return "Ordenador con configuración estandar";
	}

	@Override
	public double getPrecio() {
		return 500;
	}

}
