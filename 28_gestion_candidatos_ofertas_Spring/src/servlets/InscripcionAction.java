package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Candidato;
import model.Inscripcion;
import service.InscripcionService;

/**
 * Servlet implementation class InscripcionAction
 */
@WebServlet("/InscripcionAction")
public class InscripcionAction extends HttpServlet {
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
		String empresa = request.getParameter("empresa");
		String posicion = request.getParameter("posicion");
		double salario = Double.parseDouble(request.getParameter("salario"));
		int idCandidato = Integer.parseInt(request.getParameter("idCandidato"));
		
		Inscripcion inscripcion = new Inscripcion(0, empresa, posicion, salario, new Candidato(idCandidato, null, 0, null, null, null));
		
		service.nuevaInscripcion(inscripcion);		
	}

}
