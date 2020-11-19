package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Candidato;
import model.Inscripcion;

@Service
public class InscripcionServiceImpl implements InscripcionService {
	@Autowired
	JdbcTemplate template;

	@Override
	public void nuevaInscripcion(Inscripcion inscripcion) {
		String sql = "INSERT INTO inscripciones(empresa, posicion, salario, idCandidato) values(?, ?, ?, ?)";
		
		template.update(sql, inscripcion.getEmpresa(),
				inscripcion.getPosicion(),
				inscripcion.getSalario(),
				inscripcion.getCandidato().getIdCandidato());
	}

	@Override
	public List<Inscripcion> recuperarInscripciones() {
		
		String sql = "SELECT * FROM inscripciones, candidatos WHERE inscripciones.idCandidato = candidatos.idCandidato";
		
		return template.query(sql, (rs, f) -> new Inscripcion(rs.getInt("inscripciones.idInscripcion"), 
				rs.getString("inscripciones.empresa"), 
				rs.getString("inscripciones.posicion"), 
				rs.getDouble("inscripciones.salario"), 
				new Candidato(rs.getInt("candidatos.idCandidato"),
						rs.getString("candidatos.nombre"),
						rs.getInt("candidatos.edad"),
						rs.getString("candidatos.puesto"),
						rs.getString("candidatos.foto"),
						rs.getString("candidatos.email"))));
	}

}
