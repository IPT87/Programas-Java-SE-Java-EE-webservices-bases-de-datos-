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
@EnableJpaRepositories(basePackages = "repository",entityManagerFactoryRef = "factory",transactionManagerRef = "txManager" )
@ComponentScan(basePackages = {"service", "repository"})
@Configuration
@PropertySource("classpath:config/application.properties")
public class SpringConfig {
	@Value("${coches.driver}")
	String driver;
	@Value("${coches.url}")
	String cadena;
	@Value("${coches.user}")
	String usuario;
	@Value("${coches.pwd}")
	String pw;
	@Bean
	public DataSource crearDatasource() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(cadena);
		data.setUsername(usuario);
		data.setPassword(pw);
		return data;
	}
	/*private DataSource crearDatasource() {
        DataSource dataSource = null;
        JndiTemplate jndi = new JndiTemplate();
        try {
            dataSource = jndi.lookup("java:comp/env/refcoches", DataSource.class);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }*/
	
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
			factory.setPersistenceUnitName("cochesPU");
			factory.setDataSource(crearDatasource());
			factory.setPackagesToScan("model");
			factory.setJpaVendorAdapter(adapter());
			Properties properties = new Properties();
			properties.put("hibernate.enable_lazy_load_no_trans", true);
			factory.setJpaProperties(properties);
			return factory;
		}
		//gestor de transacci�n
		@Bean
		public JpaTransactionManager txManager() {
			JpaTransactionManager manager = new JpaTransactionManager();
			manager.setEntityManagerFactory(factory().getObject());
			return manager;
		}
}
