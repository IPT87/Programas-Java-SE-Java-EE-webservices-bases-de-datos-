package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datos {
	static String driver;
	static String cadenaConexion;
	static String user;
	static String password;
	static String FILE = "config.json";
	
	static {
		// carga del driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(cadenaConexion, user, password);
	}

	private static void cargarPropiedades() {
		
	}
	
}
