package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestExterno
 */
@WebServlet("/TestExterno")
public class TestExterno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = "https://restcountries.eu/rest/v2/all";
		URL url = new URL(dir);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		InputStream istream = con.getInputStream();
		BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(istream));
		System.out.println(reader.readLine());
	}

}
