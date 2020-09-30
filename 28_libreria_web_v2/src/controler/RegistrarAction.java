package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.LibreriaService;
import service.LibreriaServiceFactory;

/**
 * Servlet implementation class RegistrarAction
 */
@WebServlet("/RegistrarAction")
public class RegistrarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibreriaService libreriaService = LibreriaServiceFactory.getLibreriaService();
		
		Cliente cliente = new Cliente(request.getParameter("usuario"), 
				request.getParameter("email"), 
				request.getParameter("pass"), 
				Integer.parseInt(request.getParameter("telefono")));
		
		String url;
		
		if (libreriaService.addCliente(cliente)) {		
            url = "Controler?option=toSalir";            
		} else {	
			url = "Controler?option=toError";
		}
       
        request.getRequestDispatcher(url).forward(request, response);
	}

}
