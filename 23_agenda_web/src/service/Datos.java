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
			cargarPropiedades();
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(cadenaConexion, user, password);
	}

	private static void cargarPropiedades() {
		driver = "com.mysql.cj.jdbc.Driver";
		cadenaConexion = "jdbc:mysql://localhost:3306/miscontactos?serverTimezone=UTC";
		user = "root";
		password = "root";
	}
	
}
