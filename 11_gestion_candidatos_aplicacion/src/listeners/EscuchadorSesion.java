package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.Candidato;

/**
 * Application Lifecycle Listener implementation class EscuchadorSesion
 *
 */
@WebListener
public class EscuchadorSesion implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public EscuchadorSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession sesion = se.getSession();
         //crea un atributo de sesion cada vez que se inicie sesion
         sesion.setAttribute("candidatos", new ArrayList<Candidato>());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
