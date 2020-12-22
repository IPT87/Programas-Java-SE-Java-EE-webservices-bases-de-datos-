package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Alquiler;
import service.AlquileresService;

@CrossOrigin(value = "*")
@Controller
public class ReservarVehiculoController {
	@Autowired
	AlquileresService service;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date fechaInicio = null;
	Date fechaFin = null;
	
	@PostMapping(value = "doReservarVehiculo")
	public String nuevoAlquiler(@RequestParam("matricula") String matricula, @RequestParam("fechaInicio") String fechaInicio,
								@RequestParam("fechaFin") int fechaFin, @RequestParam("precioDia") double precioDia,
								@RequestParam("email") String email) {
		
		try {
			this.fechaInicio = sdf.parse(fechaInicio);
			this.fechaFin = sdf.parse(fechaInicio);
			Calendar c = Calendar.getInstance();
	        c.setTime(this.fechaFin);
	        c.add(Calendar.DATE, fechaFin);
	        this.fechaFin = c.getTime();
			
			Alquiler alquiler = new Alquiler(matricula, email, (precioDia * fechaFin), this.fechaFin, this.fechaInicio);
			service.nuevoAlquiler(alquiler);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "confirmacion";
	}

}
