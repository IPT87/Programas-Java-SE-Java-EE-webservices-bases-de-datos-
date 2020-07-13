package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import service.CuentaService;

public class TestCuentaService {

	CuentaService service;
	
	@Before
	public void setUp() throws Exception {
		service = new CuentaService(100);
	}

	@Test
	public void testIngresar() {
		service.ingresar(50);
		assertEquals(150, service.getSaldo(), 0);
	}
	
	@Test
	public void testExtraer() {
		service.extraer(50);;
		assertEquals(50, service.getSaldo(), 0);
	}

}
