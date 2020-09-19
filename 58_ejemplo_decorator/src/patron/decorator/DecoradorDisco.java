package patron.decorator;

public class DecoradorDisco implements OrdenadorBase {
	private OrdenadorBase componente;
	
	
	public DecoradorDisco(OrdenadorBase componente) {
		super();
		this.componente = componente;
	}

	@Override
	public String getDescripcion() {
		return componente.getDescripcion()+" más disco SSD";
	}

	@Override
	public double getPrecio() {
		return componente.getPrecio()+200;
	}

}
