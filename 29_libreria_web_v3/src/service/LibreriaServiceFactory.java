package service;

public class LibreriaServiceFactory {

	public static LibreriaService getLibreriaService() {
		return new LibreriaServiceImpl();
	}
	
}
