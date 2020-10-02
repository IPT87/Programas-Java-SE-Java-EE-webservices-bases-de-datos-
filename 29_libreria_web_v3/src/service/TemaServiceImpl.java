package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Libro;

public class TemaServiceImpl implements TemaService {

	@Override
	public List<String> getTema() {
		List<String> listaTemas = new ArrayList<String>();

		try (Connection con = Datos.getConnection()) {

			String sql = "SELECT * FROM temas";

			Statement ps = con.createStatement();

			ResultSet rs = ps.executeQuery(sql);

			while (rs.next()) {
				listaTemas.add(rs.getString("tema"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTemas;
	}

	@Override
	public List<Libro> getLibros(String tema) {
		List<Libro> listaLibros = new ArrayList<Libro>();
		List<String> temas = getTema();
		String temaCriterio = "todos";
		Libro libro = null;
		int idTema = 0;

		for (String t : temas) {
			if (t.contains(tema)) {
				temaCriterio = t;
				break;
			}
		}

		try (Connection con = Datos.getConnection()) {

			if (temaCriterio.equals("todos")) {
				String sql = "SELECT * FROM libros";

				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					libro = new Libro(rs.getString("autor"), rs.getString("titulo"), rs.getInt("isbn"));
					listaLibros.add(libro);
				}
				return listaLibros;
			} else {
				String sql = "SELECT * FROM temas WHERE tema=?";

				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, temaCriterio);

				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					idTema = rs.getInt("idTema");
				}

				String sql1 = "SELECT * FROM libros WHERE idTema=?";

				PreparedStatement ps1 = con.prepareStatement(sql1);

				ps1.setInt(1, idTema);

				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {
					libro = new Libro(rs1.getString("autor"), rs1.getString("titulo"), rs1.getInt("isbn"));
					listaLibros.add(libro);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaLibros;
	}

}
