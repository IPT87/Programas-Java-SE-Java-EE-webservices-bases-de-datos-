package service;

public class ContactosServiceFactory {
	public static ContactosService getContactosService() {
		return new ContactoServiceImpl();
	}
}
