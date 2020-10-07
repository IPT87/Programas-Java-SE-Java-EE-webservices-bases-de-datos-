package service;

public class CajeroServiceFactory {
	public static CajeroService getCajeroService() {
		return new CajeroServiceImpl();
	}
}
