package exceptions;

public class SinLibrosException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public SinLibrosException() {
		super("No hay libros para añadir a la lista de ventas.");
	}
}
