package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;
import model.Libro;

public class VentasServiceImpl implements VentasService {

	@Override
	public boolean procesarCompra(Cliente cliente, Libro libro) {
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
