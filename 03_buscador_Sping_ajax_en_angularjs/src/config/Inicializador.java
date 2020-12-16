package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class Inicializador implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
      // Crea el contexto raíz de la aplicación Web
      AnnotationConfigWebApplicationContext rootContext =
        new AnnotationConfigWebApplicationContext();
      //si SpringConfig no tiene nada, no se tiene porqué usar
      //registro de la clase de configuración del modelo
      rootContext.register(SpringConfig.class);
      
      // Gestiona el ciclo de vida del contexto de aplicación
      container.addListener(new ContextLoaderListener(rootContext));

      // Crea el DispatcherServlet y lo asocia al contexto de aplicación
      AnnotationConfigWebApplicationContext dispatcherContext =
        new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(MvcConfig.class);

      // Registra el DispatcherServlet
      ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
      //filtro de seguridad
      /*container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
      .addMappingForUrlPatterns(null, false, "/*");*/
    }

 }
