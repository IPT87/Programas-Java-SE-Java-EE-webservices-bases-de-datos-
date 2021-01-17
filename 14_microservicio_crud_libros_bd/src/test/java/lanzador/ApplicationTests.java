package lanzador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc // Le indicamos a Spring que nos cree una instancia del MockMvc
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class ApplicationTests {
	/* @Autowired
	LibrosService service;
	
	@Order(1)
	@Test
	void testLibros() {
		assertEquals(13, service.todosLibros().size());
	}
	
	@Order(2)
	@Test
	void testLibro() {
		assertEquals("Java 15", service.libroIsbn(1111).getTitulo());
	}
	
	@Order(3)
	@Test
	void testEliminacion() {
		service.eliminarLibro(3624);
		assertNull(service.libroIsbn(3624));
	} */
	
	@Autowired
	MockMvc mock;
	
	/* @Test
	void testRecursoLibros() throws Exception {
		mock.perform(get("/libros")).andDo(print());
	} */
	
	@Test
	void testAltaLibro() throws Exception {
		mock.perform(post("/libro")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"titulo\":\"Angular JS\",\"isbn\":4080,\"tematica\":\"programación\"}")
				).andDo(print());
		mock.perform(get("/libros/4080")).andDo(print());
	}

}
