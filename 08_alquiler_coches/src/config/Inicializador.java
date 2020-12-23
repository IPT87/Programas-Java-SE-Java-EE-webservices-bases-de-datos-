package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class Inicializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		 
		  // Crea el contexto raíz de la aplicación Web
	      AnnotationConfigWebApplicationContext rootContext =
	      new AnnotationConfigWebApplicationContext();
	      
	      //registro de la clase de configuración del modelo
	      rootContext.register(SpringConfig.class);
	      rootContext.register(SecurityConfig.class);
	      
	      // Gestiona el ciclo de vida del contexto de aplicación
	      servletContext.addListener(new ContextLoaderListener(rootContext));
	      
	      // Registra el archivo de configuración para MVC
	      AnnotationConfigWebApplicationContext dispatcherContext =
	      new AnnotationConfigWebApplicationContext();
	      dispatcherContext.register(MvcConfig.class);

	      // Crea y Registra el DispatcherServlet
	      ServletRegistration.Dynamic dispatcher =
	      servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
	      dispatcher.setLoadOnStartup(1);
	      dispatcher.addMapping("/");
	      
	      // Registro del filtro de seguridad
	      servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
	      .addMappingForUrlPatterns(null, false, "/*");

	}

}
