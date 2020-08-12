package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import model.Pedido;
import model.PedidoTienda;
import util.Utilidades;

public class GestorPedidos {
	private final String SEPARADOR = ",";
	private Path path;
	private String ruta="C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\pedidos.txt";
	
	public GestorPedidos() {
		path = Paths.get(ruta);
		
		if (!Files.exists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//almacena el pedido recibido
		public void grabarPedido(List<PedidoTienda> pedidos) {
			
			
				/* try {
					Files.writeString(
							path, 
							Utilidades.pedidoTiendaToString(p, SEPARADOR) + System.lineSeparator(), 
							StandardOpenOption.APPEND);
				} catch (IOException e) {
					e.printStackTrace();
				} */
				
				try(Connection con = Datos.getConnection()) {
					String sql = "INSERT INTO pedido(producto,unidades,precioUnitario,seccion,fecha,tienda) values (?,?,?,?,?,?)";
					PreparedStatement st = con.prepareStatement(sql);
					
					 
					for (PedidoTienda p : pedidos) {
						st.setString(1, p.getProducto());
						st.setInt(2, p.getUnidades());
						st.setDouble(3, p.getPrecioUnitario());
						st.setString(4, p.getSeccion());
						st.setDate(5, new java.sql.Date(p.getFecha().getTime()));
						st.setString(6, p.getTienda());
						st.execute();
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}
		
		public List<Pedido> pedidosFechaActual() {
			try {
				return Files.lines(path)
							.map(p -> Utilidades.construirPedido(p, SEPARADOR))
							.filter(p -> p.getFecha().compareTo(Utilidades.convertirLocalDateEnDate(LocalDate.now())) == 0)
							.collect(Collectors.toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
}
