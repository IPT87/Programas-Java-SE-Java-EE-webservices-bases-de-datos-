package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;

@RequestScoped
@Named("ventasService")
public class VentasServiceImpl implements VentasService {

	@Override
	public boolean procesarCompra(Cliente cliente, Libro libro) throws SinLibrosException {
		
		if(libro == null || cliente == null) {
			//provocamos una excepcion personalizada
			throw new SinLibrosException();
		}
		try(Connection con = Datos.getConnection();) {                       
			String sql = "INSERT INTO ventas(idCliente, idLibro, fecha) values(?, ?, NOW())";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cliente.getIdCliente());
			st.setInt(2, libro.getIsbn());
			st.execute();
			return true;
        }  catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
	}

}
