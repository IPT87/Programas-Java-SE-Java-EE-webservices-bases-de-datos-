package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import model.Caso;

public abstract class BaseService {
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public abstract Stream<Caso> streamCaso();
	
	public boolean addCaso(Caso caso) {
		try(Connection con = Datos.getConnection()) {
			try {
				String sql = "INSERT INTO comunidad(abreviatura,fecha,positivos) values (?,?,?)"; 
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, caso.getComunidad());
				st.setDate(2, new java.sql.Date(caso.getFecha().getTime()));
				st.setInt(3, caso.getPositivos());
				st.execute(); 
			} catch (Exception e) {
				System.out.println("Ya existen los datos del dia: " + sdf.format(caso.getFecha()) + ", en comunidad: " + caso.getComunidad() + "!");
			}
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
