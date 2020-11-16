package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter({ "/login.html", "/" })
public class FiltroLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Cookie[] cookies = ((HttpServletRequest)request).getCookies();
		
		if(cookies != null) { // recorremos e array de cookies solo si hay cookies
			for(Cookie ck : cookies) {
				if(ck.getName().equals("usuarioRegistrado")) {
					HttpSession sesion = ((HttpServletRequest)request).getSession();
					sesion.setAttribute("user", ck.getValue());
					request.getRequestDispatcher("buscador.jsp").forward(request, response);
				}
			}
		} else {
			// pasara el control al destinario original,
			// en nuestro caso la pagina lohin.html
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
