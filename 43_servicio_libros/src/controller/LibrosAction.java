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
	@Inject
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros=service.recuperarLibros();
		JSONArray array=new JSONArray();
		libros.forEach(libro->array.add(Utilidades.adaptadorLibroAJson(libro)));
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.print(array);
	}

}
