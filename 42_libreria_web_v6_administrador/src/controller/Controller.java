package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String url="login.jsp";
		switch(option) {
			case "doRegistrar":
				request.getRequestDispatcher("RegistrarAction").include(request, response);
				url="login.jsp";
				break;
			case "doLogin":
				request.getRequestDispatcher("LoginAction").include(request, response);
				//llamamos al TemasAction, que ya se encarga de recoger los temas
				//y ponerlos a disposición de la JSP
				request.getRequestDispatcher("TemasAction").include(request, response);
				url=(Boolean)request.getAttribute("resultado")?"temas.jsp":"error.html";
				break;
			case "doTemas":
				request.getRequestDispatcher("TemasAction").include(request, response);
				url="temas.jsp";
				break;
			case "doLibros":
				request.getRequestDispatcher("LibrosAction").include(request, response);
				url="libros.jsp";
				break;
			case "doAgregarCarrito":
            	request.getRequestDispatcher("AgregarCarritoAction").include(request, response);
            	//volvemos a recuperar los libros para la página libros.jsp
        		request.getRequestDispatcher("LibrosAction").include(request, response);
                url="libros.jsp";
                break;
			case "doProcesarCompra":
            	request.getRequestDispatcher("ProcesarCompraAction").include(request, response);
            	if((Boolean)request.getAttribute("resultado")) {
            		//recuperamos de nuevo los temas
            		request.getRequestDispatcher("TemasAction").include(request, response);
                    url="temas.jsp";
            	}else {
            		url="errorCompra.jsp";
            	}
            	
                break;
            case "doEliminarCarrito":
            	request.getRequestDispatcher("EliminarCarritoAction").include(request, response);
            	//volvemos a recuperar los libros para la página libros.jsp
        		request.getRequestDispatcher("LibrosAction").include(request, response);
                url="libros.jsp";
                break;
            case "doIdioma":
            	request.getRequestDispatcher("CambiarIdiomaAction").include(request, response);
                url="login.jsp";
                break;
            case "doConsultarVentas":
            	request.getRequestDispatcher("ConsultarVentasAction").include(request, response);
                url="ventas.jsp";
                break;
			case "toRegistro":
				url="registro.html";
				break;
			case "toSalir":
				url="login.jsp";
				break;
			case "toAdmin":
				url="administracion.html";
				break;
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	
}

