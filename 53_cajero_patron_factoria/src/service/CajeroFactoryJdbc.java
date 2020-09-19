package service;

public class CajeroFactoryJdbc extends CajeroFactory {

	@Override
	public CajeroService getCajeroService() {
		return new CajeroServiceImplJdbc();
	}

}
