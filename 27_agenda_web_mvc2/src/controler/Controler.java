package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controler
 */
@WebServlet("/Controler")
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("option");
		String url = "inicio.html";

		switch (option) {
			case "doGuardar":
				url = "GuardarAction";
				break;
			case "doRecuperar":
				url = "RecuperarAction";
				break;
			case "toDatos":
				url = "datos.html";
				break;
			case "toSalir":
				url = "inicio.html";
				break;
			case "doEliminar":
				url = "EliminarAction";
				break;
			case "toEliminarDatos":
				url = "eliminar.html";
				break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
