package service;

public abstract class CajeroFactory {

	public static CajeroFactory getFactory(int op) {
		switch (op) {
		case 0:
			return new CajeroFactoryJdbc();
		default:
			return null;
		}
	}

	public abstract CajeroService getCajeroService();
}
