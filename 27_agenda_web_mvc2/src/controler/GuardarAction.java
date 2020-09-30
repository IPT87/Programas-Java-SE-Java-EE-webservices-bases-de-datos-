package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;
import service.ContactosServiceFactory;

/**
 * Servlet implementation class Guardar
 */
@WebServlet("/GuardarAction")
public class GuardarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Expires", "0");
		
		ContactosService contactosService = ContactosServiceFactory.getContactosService();
		
		Contacto contacto = new Contacto(request.getParameter("nombre"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("edad")));
		
		contactosService.addContacto(contacto);
		request.getRequestDispatcher("inicio.html").forward(request, response);
		
	}

}
