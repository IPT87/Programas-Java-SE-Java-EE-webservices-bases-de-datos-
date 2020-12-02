package repository.adapter.entity;

import model.Candidato;

public class Utilidades {
	
	public static Candidato candidatoBuilder(CandidatoEntity entity) {
		
		return new Candidato(entity.getIdCandidato(),
							entity.getNombre(),
							entity.getPuesto(),
							entity.getFoto(),
							entity.getEmail(),
							entity.getEdad());
	}
	
	public static CandidatoEntity candidatoEntityBuilder(Candidato candidato) {
		
		CandidatoEntity entity = new CandidatoEntity();
		entity.setIdCandidato(candidato.getCodigoCandidato());
		entity.setNombre(candidato.getNombre());
		entity.setPuesto(candidato.getPuesto());
		entity.setFoto(candidato.getFoto());
		entity.setEmail(candidato.getEmail());
		entity.setEdad(candidato.getEdad());
		
		return entity;
	}
}
