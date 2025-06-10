package com.tecxter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

   @Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers(HttpMethod.GET,"/api/**").permitAll()
					.anyRequest().authenticated()
					)
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
   
   @Bean
   UserDetailsService userDetailsService() {
	   UserDetails user = User.builder().username("tharun")
			   									.password(passwordEncoder().encode("Tharun@123"))
			   									.roles("USER")
			   									.build();
	   
	   UserDetails admin = User.builder().username("manoj")
					.password(passwordEncoder().encode("Manoj@123"))
					.roles("ADMIN")
					.build();
	   return new InMemoryUserDetailsManager(user,admin);
   }
   
   
   PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
   }
}
