package exceptions;

public class SinLibrosException extends Exception {
	public SinLibrosException() {
		super("No hay libros para añadir a la lista de ventas");
	}	
}
