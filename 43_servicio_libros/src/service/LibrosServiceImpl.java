package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Libro;
import model.Tema;

@RequestScoped
@Named("librosService")
public class LibrosServiceImpl implements LibrosService {

	@Override
	public List<Libro> recuperarLibros() {

		String sql = "select * from libros, temas ";
		sql += " where libros.idTema=temas.idTema";
		List<Libro> lista = new ArrayList<>();
		try (Connection cn = Datos.getConnection();) {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Tema tema = new Tema(rs.getInt("idTema"), rs.getString("tema"));
				lista.add(new Libro(rs.getInt("isbn"), rs.getString("titulo"), rs.getString("autor"),
						rs.getDouble("precio"), rs.getInt("paginas"), tema));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return lista;
	}

}
