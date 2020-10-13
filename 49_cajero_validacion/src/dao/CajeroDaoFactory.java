package dao;

public class CajeroDaoFactory {
	public static CajeroDao getCajeroDao() {
		return new CajeroDaoImplJdbc();
	}
}
