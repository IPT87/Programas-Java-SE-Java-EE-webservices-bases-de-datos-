package servlets;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Libro;
import service.LibrosFactory;
import service.LibrosService;

/**
 * Servlet implementation class Comprobar
 */
@WebServlet("/Comprobar")
public class Comprobar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String clave = "wbpgzhNYZQOiGgXp7wu5WfG6dKHTe8/L9fxr+1SPaE0=";

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<Integer, String> usuarios = new HashMap<>();
		usuarios.put(1234, "Juan");
		usuarios.put(7777, "Paco");
		usuarios.put(4321, "Carla");
		usuarios.put(0000, "Maria");
		usuarios.put(2222, "Roberto");
		

		int pass = Integer.parseInt(request.getParameter("passUsuario"));
		String nombreUsuario = request.getParameter("usuario");
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		
		//leer la clave codificada
		/*if (encriptarSha256(pass).equals(clave)) {
			
		}*/
		
		if (usuarios.containsKey(pass)) {
			if (usuarios.get(pass).equals(nombreUsuario)) {
				session.setAttribute("usuario", nombreUsuario);
				dispatcher = request.getRequestDispatcher("eleccion.jsp");
				
				Cookie ck = new Cookie("credenciales", nombreUsuario + "-" + String.valueOf(pass));
				ck.setMaxAge(100000);
				response.addCookie(ck);
			} else {
				dispatcher = request.getRequestDispatcher("accesoDenegado.jsp");
			}
		} else {
			dispatcher = request.getRequestDispatcher("accesoDenegado.jsp");
		}
		
		dispatcher.forward(request, response);
	}
	
	private String encriptarSha256(String dato) {
		try {
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			md.update(dato.getBytes());
			byte[] enc=md.digest();
			//codificamos el array resultante en base 64
			//y creamos una cadena a partir del mismo
			return new String(Base64.getEncoder().encode(enc));
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


}
