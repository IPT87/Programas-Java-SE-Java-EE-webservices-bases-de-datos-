package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;
import model.Venta;

public class VentasServiceImpl implements VentasService {
	private static final double PAGINASIZE=5;
	@Override
	public void nuevaVenta(Cliente cliente, List<Libro> libros) throws SinLibrosException{
		if(cliente==null||libros==null||libros.size()==0) {
			//provocamos una excepción personalizada
			throw new SinLibrosException();
		}
		try(Connection cn=Datos.getConnection();) {                       	           
            String sql="insert into ventas (idCliente, idLibro, fecha) values(?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
            for(Libro libro:libros) {
            	ps.setInt(1, cliente.getIdCliente());
            	ps.setInt(2, libro.getIsbn());
            	ps.setTimestamp(3, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            	ps.execute();
            }
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }

	}

	@Override
	public List<Venta> obtenerVentas() {
		String sql="select * from ventas, clientes, libros ";
		sql+=" where ventas.idCliente=clientes.idCliente and";
		sql+=" ventas.idLibro=libros.isbn";
		List<Venta> ventas=new ArrayList<>();
		try(Connection cn=Datos.getConnection();) {                       	                      
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
            	Libro vendido=new Libro(rs.getInt("isbn"),
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getInt("precio"),
						rs.getInt("paginas"),
						rs.getInt("idTema"));
				Cliente comprador=new Cliente(
						rs.getInt("idCliente"),
						rs.getString("usuario"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getInt("telefono"));
				Venta realizada=new Venta(comprador, vendido,rs.getTimestamp("fecha").toLocalDateTime());
				ventas.add(realizada);
            }
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
		return ventas;
				
	}

	@Override
	public List<Venta> obtenerVentasPorPagina(int numeroPagina) {
		String sql="select * from ventas, clientes, libros ";
		sql+=" where ventas.idCliente=clientes.idCliente and";
		sql+=" ventas.idLibro=libros.isbn";
		sql+=" limit "+(int)PAGINASIZE+" offset "+(numeroPagina-1)*(int)PAGINASIZE;
		List<Venta> ventas=new ArrayList<>();
		try(Connection cn=Datos.getConnection();) {                       	                      
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
            	Libro vendido=new Libro(rs.getInt("isbn"),
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getInt("precio"),
						rs.getInt("paginas"),
						rs.getInt("idTema"));
				Cliente comprador=new Cliente(
						rs.getInt("idCliente"),
						rs.getString("usuario"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getInt("telefono"));
				Venta realizada=new Venta(comprador, vendido,rs.getTimestamp("fecha").toLocalDateTime());
				ventas.add(realizada);
            }
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
		return ventas;
	}

	@Override
	public int paginasVentas() {
		int paginas=0;
		try(Connection cn=Datos.getConnection();) {                       	           
            String sql="select count(*) from ventas";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
            ResultSet rs=ps.executeQuery();
            rs.next();
            paginas=(int)Math.ceil(rs.getInt(1)/PAGINASIZE);
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
		return paginas;
	}

}
