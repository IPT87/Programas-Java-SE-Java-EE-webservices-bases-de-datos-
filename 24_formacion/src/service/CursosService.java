package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Curso;

public class CursosService {
	
	
	public List<Curso> recuperarCursos() {	
		try(Connection con = Datos.getConnection()) {
			List<Curso> cursos = new ArrayList<>();
			String sql = "SELECT * FROM cursos";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				cursos.add(new Curso(rs.getInt("idCurso"),
						rs.getString("denominacion"),
						rs.getInt("duracion"),
						rs.getDate("fechaInicio")));
			}
			return cursos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean altaCurso(Curso curso) {
		try(Connection con = Datos.getConnection()) {
			String sql = "INSERT INTO cursos(denominacion,duracion,fechaInicio) values (?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, curso.getDenominacion());
			st.setInt(2, curso.getDuracion());
			st.setDate(3, new java.sql.Date(curso.getFechaInicio().getTime()));
			st.execute();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Curso> cursosEntreDosFechas(Date fechaInicio, Date fechaFin) {
		try(Connection con = Datos.getConnection()) {
			List<Curso> cursos = new ArrayList<>();
			String sql = "SELECT * FROM cursos WHERE fechaInicio>? AND fechaInicio<?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setDate(1, new java.sql.Date(fechaInicio.getTime()));
			st.setDate(2, new java.sql.Date(fechaFin.getTime()));
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				cursos.add(new Curso(rs.getInt("idCurso"),
						rs.getString("denominacion"),
						rs.getInt("duracion"),
						rs.getDate("fechaInicio")));
			}
			return cursos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int totalCursos() {
		try(Connection con = Datos.getConnection()) {
			CallableStatement cs = con.prepareCall("{call totalCursos(?)}");
			//se registran los parametros de salida
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			return cs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
