package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisesService;

/**
 * Servlet implementation class MostrarPaisesAction
 */
@WebServlet("/MostrarPaisesAction")
public class MostrarPaisesAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Inject
	PaisesService paisesService;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Pais> paises = paisesService.recuperarPaises();
		Set<String> nombresPaises = paises.keySet();
		List<String> listaPaises = nombresPaises.stream().sorted().collect(Collectors.toList());
		
		HttpSession session = request.getSession();
		request.setAttribute("nombresPaises", listaPaises);
		session.setAttribute("paises", paises);
	}

}
