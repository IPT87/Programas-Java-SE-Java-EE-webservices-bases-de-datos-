package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Contacto;

public class ContactoServiceImpl implements ContactosService {
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
	
	@Override
	public boolean addContacto(Contacto contacto) {
		try (Connection con = Datos.getConnection()) {
			//opcion Statement
			/* String sql = "insert into contactos(nombre, email, edad) values('" + contacto.getNombre() + "', '" + contacto.getEmail() + "', '" + contacto.getEdad() + "')";
			Statement st = con.createStatement();
			st.execute(sql); */
			
			//opcion PreparedStatement
			String sql = "INSERT into contactos(nombre, email, edad) values(?, ?, ?)";
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
	
	@Override
	public boolean eliminarContacto(String email) {
		
		try (Connection con = Datos.getConnection()) {
			// envio de instruccion SQL
			String sql = "DELETE FROM contactos WHERE email=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			
			return st.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Contacto buscarContacto(String email) {
		try (Connection con = Datos.getConnection()) {
			// envio de instruccion SQL
			String sql = "SELECT * FROM contactos WHERE email=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				return new Contacto(rs.getInt("idContacto"), rs.getString("nombre"), rs.getString("email"), rs.getInt("edad"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Contacto> mostrarContactos() {
		List<Contacto> listaContactos = new ArrayList<>();
		
		try (Connection con = Datos.getConnection()) {
			// envio de instruccion SQL
			String sql = "SELECT * FROM contactos";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				listaContactos.add(new Contacto(rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaContactos;
	}
}
