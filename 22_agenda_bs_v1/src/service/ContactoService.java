package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Contacto;

public class ContactoService {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String cadenaConexion = "jdbc:mysql://localhost:3306/miscontactos?serverTimezone=UTC";
	static String user = "root";
	static String password = "root";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addContacto(Contacto contacto) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, password)) {
			//opcion Statement
			/* String sql = "insert into contactos(nombre, email, edad) values('" + contacto.getNombre() + "', '" + contacto.getEmail() + "', '" + contacto.getEdad() + "')";
			Statement st = con.createStatement();
			st.execute(sql); */
			
			//opcion PreparedStatement
			String sql = "insert into contactos(nombre, email, edad) values(?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, contacto.getNombre());
			st.setString(2, contacto.getEmail());
			st.setInt(3, contacto.getEdad());
			st.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
