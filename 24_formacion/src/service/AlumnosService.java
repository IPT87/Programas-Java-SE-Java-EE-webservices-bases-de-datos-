package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;

public class AlumnosService {

	public List<Alumno> matriculadosCursoDado(String denominacionCurso) {
		try (Connection con = Datos.getConnection()) {
			List<Alumno> alumnos = new ArrayList<>();
			String sql = "SELECT alumnos.* FROM alumnos,cursos WHERE alumnos.idCurso=cursos.idCurso AND cursos.denominacion=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, denominacionCurso);
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				alumnos.add(new Alumno(rs.getInt("dni"), 
						rs.getString("nombre"), 
						rs.getString("email"),
						rs.getInt("edad"), 
						rs.getInt("idCurso")));
			}
			return alumnos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
