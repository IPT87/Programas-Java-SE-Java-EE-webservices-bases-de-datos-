package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import model.Libro;
import service.LibrosService;
import util.Utilidades;

/**
 * Servlet implementation class LibrosAction
 */
@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Inject
	LibrosService librosService;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros = librosService.recuperarLibros();
		JSONArray array = new JSONArray();
		libros.forEach(libro -> array.add(Utilidades.adaptadorLibroAJSON(libro)));
		response.setContentType("application/json");
		response.setCharacterEncoding("iso-8859-1");
		PrintWriter out = response.getWriter();
		out.print(array);
	}

}
