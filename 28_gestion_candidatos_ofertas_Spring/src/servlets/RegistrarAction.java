package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Candidato;
import service.CandidatosService;

/**
 * Servlet implementation class Registrar
 */
@MultipartConfig
@WebServlet("/RegistrarAction")
public class RegistrarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CandidatosService service;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String puesto = request.getParameter("puesto");
		//recuperar el parametro foto
		Part foto = request.getPart("foto");
		String nombreFichero = obtenerNombreFichero(foto);
		String email = request.getParameter("email");
		
		Candidato candidato = new Candidato(0, nombre, edad, puesto, nombreFichero, email);
		
		service.altaCandidato(candidato);
		
		guardarFicheroEnServidor(request, foto, nombreFichero);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("inicio.html");
		dispatcher.forward(request, response);
	}

	private String obtenerNombreFichero(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) { 
			if (cd.trim().startsWith("filename")) { 
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", ""); 
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix. 
			} 
		} 
		return null; 
	}
	
	private void guardarFicheroEnServidor(HttpServletRequest request, Part part, String nombreFichero) {
		String url = request.getServletContext().getRealPath("/");
		
		try {
			part.write(url + "\\" + nombreFichero);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*try (InputStream input=part.getInputStream();
				FileOutputStream output = new FileOutputStream(url + nombreFichero);) {
	        int leido = 0;
	        leido = input.read();
	        while (leido != -1) {
	            output.write(leido);
	            leido = input.read();
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }*/
		
	}
	
}
