package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

class ClientesServiceImpl implements ClientesService {

	@Override
	public Cliente validarCliente(String user, String password) {
		Cliente c=null;
		try(Connection cn=Datos.getConnection();) {                       
	           
            String sql="Select * from clientes where ";
            sql+="usuario=? and password=?";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, user);
               ps.setString(2, password);
               
               //ejecutamos
              ResultSet rs= ps.executeQuery();
              if(rs.next()){
            	   c=new Cliente(rs.getInt("idCliente"), 
            			  rs.getString("usuario"), 
            			  rs.getString("password"),
            			  rs.getString("email"),
            			  rs.getInt("telefono"));
              }
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        } 
		return c;
	}

	@Override
	public boolean registrarCliente(Cliente cliente) {
		boolean resultado=false;
		try(Connection cn=Datos.getConnection();) {                       
	           
            String sql="insert into clientes(usuario, password,email,telefono) values(?,?,?,?)";
            
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, cliente.getUsuario());
               ps.setString(2, cliente.getPassword());
               ps.setString(3, cliente.getEmail());
               ps.setInt(4, cliente.getTelefono());
               //ejecutamos
              ps.execute();
              resultado=true;
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        } 
		return resultado;
	}

	
}

