package exceptions;

public class SinLibrosException extends Exception {
	public SinLibrosException() {
		super("No hay libros para a�adir a la lista de ventas");
	}	
}
