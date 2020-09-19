package service;

import util.Utilidades;

public abstract class CovidFactory {

	public static CovidFactory getFactory() {
		int opcion=Utilidades.getOpcion();
		switch(opcion) {
			case 0:
				return new CovidFactoryCsv();
			
			case 1:
				return new CovidFactoryJson();
		}
		return null;
	}
	public abstract BaseService getBaseService();
}
