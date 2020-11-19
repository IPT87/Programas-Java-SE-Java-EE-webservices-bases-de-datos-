package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Inscripcion;
import service.InscripcionService;

/**
 * Servlet implementation class RecuperarInscripcionesAction
 */
@WebServlet("/RecuperarInscripcionesAction")
public class RecuperarInscripcionesAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	InscripcionService service;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Inscripcion> inscripciones = service.recuperarInscripciones();
		request.setAttribute("inscripciones", inscripciones);
	}

}
