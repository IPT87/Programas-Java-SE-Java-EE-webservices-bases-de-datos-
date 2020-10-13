package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisesServiceImpl;

/**
 * Servlet implementation class RecuperarDatosPaisAction
 */
@WebServlet("/RecuperarDatosPaisAction")
public class RecuperarDatosPaisAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombrePais = request.getParameter("pais");
		HttpSession session = request.getSession();
		Map<String, Pais> paises = (Map<String, Pais>) session.getAttribute("paises");
		
		Pais pais = paises.get(nombrePais);
		request.setAttribute("datosPais", pais);
	}

}
