package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class LibreriaServiceImpl implements LibreriaService {

	@Override
	public Cliente validarCliente(String user, String password) {
		Cliente c = null;
		
		try (Connection con = Datos.getConnection()) {
			
			    String sql = "SELECT * FROM clientes WHERE ";
	            sql += "usuario=? and password=?";
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

}
