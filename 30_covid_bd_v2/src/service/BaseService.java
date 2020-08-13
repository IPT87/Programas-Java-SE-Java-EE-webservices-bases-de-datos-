package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import model.Caso;

public abstract class BaseService {
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public abstract Stream<Caso> streamCaso();
	
	public boolean addCaso(Caso caso) {
		try(Connection con = Datos.getConnection()) {
			String sql = "SELECT * FROM comunidad WHERE abreviatura = '" + caso.getComunidad() + "' AND fecha = '" + sdf.format(caso.getFecha()) + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (!rs.next()) {
				String sql1 = "INSERT INTO comunidad(abreviatura,fecha,positivos) values (?,?,?)"; 
				PreparedStatement st1 = con.prepareStatement(sql1);
				st1.setString(1, caso.getComunidad());
				st1.setDate(2, new java.sql.Date(caso.getFecha().getTime()));
				st1.setInt(3, caso.getPositivos());
				st1.execute();
				
				return true;
			} else {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
