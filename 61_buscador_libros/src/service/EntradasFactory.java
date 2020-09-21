package service;

public class EntradasFactory {
	
	public static EntradasService getEntradasService() {
		return new EntradasServiceImpl();
	}
}
