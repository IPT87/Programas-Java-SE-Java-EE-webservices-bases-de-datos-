package service;

public class TemaServiceFactory {

	public static TemaService getTemaService() {
		return new TemaServiceImpl();
	}
	
}
