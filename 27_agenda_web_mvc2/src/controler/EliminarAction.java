package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContactosService;
import service.ContactosServiceFactory;

/**
 * Servlet implementation class EliminarAction
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactosService contactosService = ContactosServiceFactory.getContactosService();
		
		String email = request.getParameter("email");
		
		if (contactosService.eliminarContacto(email)) {
			request.getRequestDispatcher("inicio.html").forward(request, response);
		}
		
		request.getRequestDispatcher("error.html").forward(request, response);
	}

}
