package demo.exemple.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer->
				configurer
				.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
		);
		//use HTTP Basic authentication
		http.httpBasic();
		//disable Corss Site Request Forgery
		//In general, not required for statless REST APIs that use POST, PUT, DELETE and/or PATCH

		http.csrf().disable();
		return http.build();
	}
}
