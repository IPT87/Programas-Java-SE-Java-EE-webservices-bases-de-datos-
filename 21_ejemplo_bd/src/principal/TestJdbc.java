package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String cadenaConexion = "jdbc:mysql://localhost:3306/miscontactos?serverTimezone=UTC";
	static String user = "root";
	static String password = "root";

	static {
		// carga del driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(cadenaConexion, user, password)) {
			// envio de instruccion SQL
			String sql = "INSERT into contactos(nombre, email, edad) values('otra prueba', 'otra@gmail.com', 40)";
			Statement st = con.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
