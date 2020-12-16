package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "repository", entityManagerFactoryRef = "factory", transactionManagerRef = "txManager")
@ComponentScan(basePackages = {"service", "repository"})
@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {
	
	@Value("${gestion.candidatos.driver}")
	String driver;
	@Value("${gestion.candidatos.url}")
	String url;
	@Value("${gestion.candidatos.user}")
	String usuario;
	@Value("${gestion.candidatos.pwd}")
	String pwd;
	
	private DataSource crearDataSource() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(url);
		data.setUsername(usuario);
		data.setPassword(pwd);
		return data;
	}
	
	/*private DataSource crearDataSource() {
        DataSource dataSource = null;
        JndiTemplate jndi = new JndiTemplate();
        try {
            dataSource = jndi.lookup("java:comp/env/refempresa", DataSource.class);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }*/

	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/toAltaAlumno").setViewName("altaalumno");
	    registry.addViewController("/toAltaCurso").setViewName("altacurso");
	    registry.addViewController("/toMenu").setViewName("menu");
	    registry.addViewController("/toMatriculas").setViewName("matriculas");
	    registry.addViewController("/").setViewName("menu");
	 }

	//adaptador de Hibernate
	@Bean
	public HibernateJpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adp = new HibernateJpaVendorAdapter();
		adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adp;
	}
		
	//factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
	@Bean
	public LocalContainerEntityManagerFactoryBean factory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("formacionPU");
		factory.setDataSource(crearDataSource());
		factory.setPackagesToScan("model");
		factory.setJpaVendorAdapter(adapter());
		Properties properties=new Properties();
		properties.put("hibernate.enable_lazy_load_no_trans",true);
		factory.setJpaProperties(properties);
		return factory;
	}
		
	//gestor de transacción
	@Bean
	public JpaTransactionManager txManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory().getObject());
		return manager;
	}

}
