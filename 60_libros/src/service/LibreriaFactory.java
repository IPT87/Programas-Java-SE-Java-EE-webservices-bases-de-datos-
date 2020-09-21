package service;

public abstract class LibreriaFactory {
	
	public static LibrosService getLibrosService() {
		return new LibrosServiceImpl();
	}
}
