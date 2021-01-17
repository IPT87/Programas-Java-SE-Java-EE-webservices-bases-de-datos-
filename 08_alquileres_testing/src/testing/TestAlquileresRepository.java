package testing;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.SpringConfig;
import model.Alquiler;
import repository.AlquileresRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
public class TestAlquileresRepository {
	@Autowired
	AlquileresRepository alquileresRepository;

	@Test
	public void testAlquileresVechiculo() {
		assertEquals(3, alquileresRepository.alquileresVechiculo("0348GDB").size());
	}

	@Test
	public void testFacturacionVehiculo() {
		assertEquals(573, alquileresRepository.facturacionVehiculo("0348GDB"), 0.0);
	}
	
	@Test
	public void testAlquileresEntreFechas() {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.YEAR, 2021);
		calendar1.set(Calendar.MONTH, 0);
		calendar1.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.YEAR, 2021);
		calendar2.set(Calendar.MONTH, 0);
		calendar2.set(Calendar.DAY_OF_MONTH, 15);
		
		List<Alquiler> alquileres = alquileresRepository.alquileresEntreFechas(calendar1.getTime(), calendar2.getTime());
		alquileres.forEach(a -> System.out.println(a.getFechaInicio() + "-" + a.getFechaFin()));
		
	}

}
