package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{	
	//definici�n roles y usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
        .inMemoryAuthentication()
        .withUser("user1")
          .password("{noop}user1") 
          .roles("USER")
          .and()
        .withUser("user2")
          .password("{noop}user2")
          .roles("ADMIN");
		
		
		/*la seguiente configuraci�n ser� para el caso de 
		 * usuarios en una base de datos
		 * auth.jdbcAuthentication().dataSource(dataSource)
        	.usersByUsernameQuery("select username, password, enabled"
            	+ " from users where username=?")
        	.authoritiesByUsernameQuery("select username, authority "
            	+ "from authorities where username=?");
		 */
	}
	//definici�n de pol�ticas de seguridad
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		  .authorizeRequests()
	      .and()
	      .exceptionHandling().accessDeniedPage("/accesoRestringido.html");
		http.csrf().disable()
		.authorizeRequests()
		//solo los miembros del rol admin podr�n realizar altas
		//y para buscar cuentas tendr�n que estar autenticados
		.antMatchers("/menu.html").hasAnyRole("USER","ADMIN")
		.antMatchers("/").hasAnyRole("USER","ADMIN")
		.antMatchers("/toReservas").hasRole("ADMIN")
		.antMatchers("/toNuevoVehiculo").hasRole("ADMIN")
		.antMatchers("/doFacturacion").hasRole("ADMIN")
		.and()
		//.httpBasic()
		.formLogin()
		.loginPage("/login")
	       .loginProcessingUrl("/security_check")
	       .usernameParameter("j_username").passwordParameter("j_password");
	
	}
	
}
