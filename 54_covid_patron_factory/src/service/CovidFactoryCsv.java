package service;

import util.Utilidades;

public class CovidFactoryCsv extends CovidFactory {

	@Override
	public BaseService getBaseService() {
		return new CsvServiceImpl(Utilidades.getRutaCsv());
	}

}
