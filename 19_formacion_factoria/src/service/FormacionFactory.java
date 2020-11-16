package service;

public class FormacionFactory {
	public static FormacionService getFormacionService() {
		return new FormacionServiceImpl();
	}
}
