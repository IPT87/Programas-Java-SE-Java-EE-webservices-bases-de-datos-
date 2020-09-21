package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Libro;

class LibrosServiceImpl implements LibrosService {

	@Override
	public List<Libro> getLibros() {
		
		List<Libro> libros = new ArrayList<>();
		
		try(Connection con = Datos.getConnection()) {
			
			String sql = "SELECT * FROM libros";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				libros.add(new Libro(rs.getInt("isbn"), rs.getString("titulo"), rs.getDouble("precio"), rs.getString("autor"),
						rs.getInt("idTema"), rs.getInt("paginas")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return libros;
	}

	@Override
	public String getTema(int idTema) {
		
		try(Connection con = Datos.getConnection()) {
			String sql = "SELECT tema FROM temas WHERE idTema = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idTema);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				return rs.getString(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public double getFacturacion(int isbn) {
		
		double facturacion = 0.0;
		double precio = 0.0;
		int count = 0;
		
		try(Connection con = Datos.getConnection()) {
			String sql = "SELECT COUNT(*) FROM ventas WHERE idLibro = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, isbn);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
			
			String sql1 = "SELECT precio FROM libros WHERE isbn = ?";
			PreparedStatement st1 = con.prepareStatement(sql1);
			st1.setInt(1, isbn);
			ResultSet rs1 = st1.executeQuery();

			if (rs1.next()) {
				precio = rs1.getDouble(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return 0.0;
		}
		
		facturacion = (precio * count);
		
		return facturacion;
	}

}
