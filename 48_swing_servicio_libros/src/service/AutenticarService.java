package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AutenticarService {
	public boolean validarCliente(String user, String password) {
		
		try(Connection con = Datos.getConnection();) {                       
	           
            String sql = "SELECT * FROM clientes WHERE usuario = ? AND password = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, password);
               
            ResultSet rs= ps.executeQuery();
              
            if (rs.next()) {
            	return true;
             }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
		
		return false;
	}
}
