package service;

public class LibrosFactory {
	public static LibrosService getLibrosService() {
		return new LibrosServiceImpl();
	}
}