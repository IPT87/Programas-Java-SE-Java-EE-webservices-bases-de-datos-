package service;

import util.Utilidades;

public class CovidFactoryJson extends CovidFactory {

	@Override
	public BaseService getBaseService() {
		return new JsonServiceImpl(Utilidades.getRutaJson());
	}

}
