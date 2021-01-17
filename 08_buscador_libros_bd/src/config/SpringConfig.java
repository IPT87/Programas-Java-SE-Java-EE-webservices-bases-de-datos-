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

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "repository", entityManagerFactoryRef = "factory", transactionManagerRef = "txManager")
@ComponentScan(basePackages = {"service", "repository"})
@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {
	
	@Value("${gestion.libreria.driver}")
	String driver;
	@Value("${gestion.libreria.url}")
	String url;
	@Value("${gestion.libreria.user}")
	String usuario;
	@Value("${gestion.libreria.pwd}")
	String pwd;
	
	private DataSource crearDataSource() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(url);
		data.setUsername(usuario);
		data.setPassword(pwd);
		return data;
	}
	
	// Adaptador de Hibernate
	@Bean
	public HibernateJpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adp = new HibernateJpaVendorAdapter();
		adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adp;
	}
			
	// Factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
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
			
	// Gestor de transacción
	@Bean
	public JpaTransactionManager txManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory().getObject());
		return manager;
	}
	
}
