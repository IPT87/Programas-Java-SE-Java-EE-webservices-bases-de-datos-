package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MegustaListener
 *
 */
@WebListener
public class MegustaListener implements ServletContextListener, HttpSessionListener {
	
    /**
     * Default constructor. 
     */
    public MegustaListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession sesion = se.getSession();
         sesion.setAttribute("contador", 0);
         
         //incrementamos el contador de usuarios activos (atributo de aplicacion)
         ServletContext context = se.getSession().getServletContext();
         int activos = (Integer) context.getAttribute("contadorActivos");
         context.setAttribute("contadorActivos", ++activos);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//decrementamos el contador de usuarios activos (atributo de aplicacion)
        ServletContext context = se.getSession().getServletContext();
        int activos = (Integer) context.getAttribute("contadorActivos");
        context.setAttribute("contadorActivos", --activos);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext context = sce.getServletContext();
         context.setAttribute("megusta", 0);
         
         //inicializamos el contador de usuarios activos
         context.setAttribute("contadorActivos", 0);
    }
    
}
