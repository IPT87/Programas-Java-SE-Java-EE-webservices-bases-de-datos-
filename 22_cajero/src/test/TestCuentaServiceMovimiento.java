package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import service.CuentaServiceMovimiento;

public class TestCuentaServiceMovimiento {
	
	CuentaServiceMovimiento service;

	@Before
	public void setUp() throws Exception {
		service = new CuentaServiceMovimiento(50);
	}

	@Test
	public void testIngresar() {
		service.ingresar(50);
		assertEquals(50, service.getSaldo(), 0);
	}

	@Test
	public void testExtraer() {
		service.extraer(50);
		assertEquals(0, service.getSaldo(), 0);
	}
	
	@Test
	public void testListaSize() {
		service.ingresar(50);
		service.extraer(25);
		assertEquals(2, service.getLista().size(), 0);
	}

}
