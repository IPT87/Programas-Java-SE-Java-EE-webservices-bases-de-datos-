package service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Caso;
import util.Utilidades;

public abstract class BaseServiceImpl implements BaseService {
	
	
	@Override
	public List<Caso> casosEntreFechas(Date fechaini, Date fechafin){
		return streamCaso()
			.filter(c->(c.getFecha().getTime()>=fechaini.getTime())&&(c.getFecha().getTime()<=fechafin.getTime()))
			.collect(Collectors.toList());
	}
	@Override
	public List<Caso> casosEntreFechasComunidad(Date fechaini, Date fechafin, String comunidad){
		return casosEntreFechas(fechaini,fechafin)
			.stream()
			.filter(c->c.getComunidad().equals(comunidad))
			.collect(Collectors.toList());
	}
	@Override
	public List<String> comunidades(){
		return
				Utilidades.getComunidades()
				.stream()
				.sorted((c1,c2)->c1.compareTo(c2))
				.collect(Collectors.toList());
		
		//return new ArrayList<String>(Utilidades.getComunidades());
		/*return streamCaso()
				.map(c->c.getComunidad())
				.distinct()
				.collect(Collectors.toList());*/
		
	}
	
	@Override
	public int casosEnDia(Date fecha) {
		return streamCaso()
			.filter(c->c.getFecha().compareTo(fecha)==0)
			//.collect(Collectors.summingInt(c->c.getPositivos()));
			.collect(Collectors.summingInt(Caso::getPositivos));
	}
	
	@Override
	public Date picoContagios() {
		/*Map<Date,List<Caso>> grupoPorFecha= streamCaso()
				.collect(Collectors.groupingBy(Caso::getFecha));*/
		return streamCaso()
				.collect(Collectors.groupingBy(Caso::getFecha))
				.keySet().stream()
				/*.max((d1,d2)->grupoPorFecha.get(d1).stream().mapToInt(Caso::getPositivos).sum()-
					grupoPorFecha.get(d2).stream().mapToInt(Caso::getPositivos).sum())
				.get();*/
				.max((d1,d2)->casosEnDia(d1)-casosEnDia(d2))
				.get();
			
	}
	
	@Override
	public int mediaPositivos() {
		Map<Date,List<Caso>> grupoPorFecha= streamCaso()
				.collect(Collectors.groupingBy(Caso::getFecha));
		return grupoPorFecha.values().stream()
			.collect(Collectors.averagingInt(l->l.stream().mapToInt(Caso::getPositivos).sum()))
			.intValue();			
	}
	
	@Override
	public int totalPositivosComunidad(String nombre) {
		return streamCaso()
			.filter(c->c.getComunidad().equals(nombre))
			.mapToInt(Caso::getPositivos)
			.sum();
	}
	
	@Override
	public Map<String,List<Caso>> casosPorComunidad(){
		return streamCaso()
				.collect(Collectors.groupingBy(Caso::getComunidad));
	}
	@Override
	public List<Caso> casosDeComunidad(String comunidad){
		return casosPorComunidad()
				.get(comunidad);
				
	}
	
}
