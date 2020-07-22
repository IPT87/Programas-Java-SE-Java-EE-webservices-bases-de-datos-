package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import service.ServicePaises;

public class TestPaises {
	ServicePaises service;

	@Before
	public void setUp() throws Exception {
		service = new ServicePaises();
	}

	@Test
	public void testPaisesMasHabitantesValor() {
		assertEquals(3, service.paisesMasHabitantesValor(120_000_000));
	}
	
	@Test
	public void testTemperaturaMediaPaises() {
		assertEquals(18.53, service.temperaturaMediaPaises(), 0);
	}
	
	@Test
	public void testAlgunPaisCondicion() {
		assertEquals(true, service.algunPaisCondicion(96_000_000, 1800));
	}
	
	@Test
	public void testPaisMasPoblado() {
		assertEquals("USA", service.paisMasPoblado().getNombre());
	}
	
	@Test
	public void testPaisesFundacionAnterior() {
		assertEquals(3, service.paisesFundacionAnterior(1700).size());
	}
	
	@Test
	public void testContinenteConMasPaises() {
		assertEquals("Europe", service.continenteConMasPaises());
	}

	@Test
	public void testPaisesPorContinente() {
		assertEquals("Spain", service.paisesPorContinente().get("Europe").get(0).getNombre());
	}
	
}
