package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.SpringConfig;
import repository.VehiculosRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
public class TestVehiculosRepository {
	@Autowired
	VehiculosRepository repository;
	
	@Test
	public void testTotalVehiculos() {
		assertEquals(11, repository.totalVehiculos().size());
	}
	
}
