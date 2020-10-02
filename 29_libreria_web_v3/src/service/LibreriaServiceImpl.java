package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import model.Cliente;

public class LibreriaServiceImpl implements LibreriaService {

	@Override
	public Cliente validarCliente(String user, String password) {
		Cliente c = null;
		
		try (Connection con = Datos.getConnection()) {
			
			    String sql = "SELECT * FROM clientes WHERE usuario=? AND password=?";
	            
	            //creamos consulta preparada:
	            PreparedStatement ps = con.prepareStatement(sql);
	               //Sustituimos parametros por valores
	               ps.setString(1, user);
	               ps.setString(2, password);
	               
	              //ejecutamos
	              ResultSet rs = ps.executeQuery();
	              if (rs.next()) {
	            	   c = new Cliente(rs.getInt("idCliente"), 
	            			  rs.getString("usuario"), 
	            			  rs.getString("password"),
	            			  rs.getString("email"),
	            			  rs.getInt("telefono"));
	              }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public boolean addCliente(Cliente cliente) {
		
		try (Connection con = Datos.getConnection()) {
			
			String sql = "INSERT INTO clientes(usuario, email, password, telefono) values(?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cliente.getNombre());
			st.setString(2, cliente.getEmail());
			st.setString(3, cliente.getPassword());
			st.setInt(4, cliente.getTelefono());
			st.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
