package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LibreriaFactory;
import service.VentasService;

/**
 * Servlet implementation class ConsultarVentasController
 */
@WebServlet("/ConsultarVentasAction")
public class ConsultarVentasAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VentasService service=LibreriaFactory.getVentasService();
		//recogemos el número de página a mostrar, si aún no se ha seleccionado página
		//recuperaremos la primera página
		int pagina=request.getParameter("pagina")!=null?Integer.parseInt(request.getParameter("pagina")):1;
		request.setAttribute("ventas", service.obtenerVentasPorPagina(pagina));
		request.setAttribute("totalPaginas", service.paginasVentas());
	}

}

