package demo.exemple.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails tabbabi = User.builder()
				.username("mohamed")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		UserDetails wahada = User.builder()
				.username("mouna")
				.password("{noop}test123")
				.roles("EMPOLUEE","MANAGER")
				.build();
		UserDetails benmansour = User.builder()
				.username("damin")
				.password("{noop}test123")
				.roles("EMPOLUEE","MANAGER","ADMIN")
				.build();
		return new InMemoryUserDetailsManager(tabbabi,wahada,benmansour);
	}
}
