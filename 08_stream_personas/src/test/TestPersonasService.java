package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import service.PersonasService;

public class TestPersonasService {
	private PersonasService ps;

	@Before
	public void setUp() throws Exception {
		ps = new PersonasService();
	}

	@Test
	public void testPersonaMasJoven() {
		assertEquals(17, ps.obtenerMasJoven().getEdad(), 0);
	}
	
	@Test
	public void testSuperiorMedia() {
		assertEquals(4, ps.superiorMedia(), 0);
	}
	
	@Test
	public void testOrdenadasPorEdad1() {
		assertEquals(44, ps.ordenadasPorEdad().get(5).getEdad(), 0);
	}
	
	@Test
	public void testOrdenadasPorEdad2() {
		assertEquals(20, ps.ordenadasPorEdad().get(1).getEdad(), 0);
	}
	
	@Test
	public void testNombres1() {
		assertEquals("Elena", ps.nombres().get(2));
	}
	
	@Test
	public void testNombres2() {
		assertEquals("Alicia", ps.nombres().get(5));
	}
	
	@Test
	public void testDominio1() {
		assertEquals("Santiago", ps.personasDominio("net").get(0).getNombre());
	}
	
	@Test
	public void testDominio2() {
		assertEquals("Lucas", ps.personasDominio("es").get(1).getNombre());
	}

}
