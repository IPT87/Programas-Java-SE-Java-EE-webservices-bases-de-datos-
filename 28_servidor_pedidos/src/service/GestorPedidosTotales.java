package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;
import model.PedidoTienda;

public class GestorPedidosTotales {
	
	public List<PedidoTienda> recuperarPedidos(String tienda) {
		List<PedidoTienda> pedidos=new ArrayList<PedidoTienda>();
		try (Connection con = Datos.getConnection()) {
			
			String sql = "select * from pedidos where tienda=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			// El primer campo representa siempre la tienda
			
			st.setString(1, tienda);
			
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				
				pedidos.add(new PedidoTienda(rs.getString("producto"),
						rs.getInt("unidades"),
						rs.getDouble("precioUnitario"),
						rs.getString("seccion"),
						rs.getDate("fecha"),
						tienda
						));
			}
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return pedidos;

	} 
}
