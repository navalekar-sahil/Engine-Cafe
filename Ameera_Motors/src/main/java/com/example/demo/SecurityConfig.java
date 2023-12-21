package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userService() {
		UserDetails firstUser = User.withUsername("sam").password(passwordEncoder().encode("123")).roles("USER")
				.build();

		// ===================user 2==================//
		UserDetails secondUser = User.withUsername("sahil").password(passwordEncoder().encode("123"))
				.roles("USER", "ADMIN").build();

		// data will store in inmemory

		InMemoryUserDetailsManager data = new InMemoryUserDetailsManager(firstUser, secondUser);
		return data;
	}

	@Bean
	public SecurityFilterChain setPermissions(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(authorize ->

		authorize.requestMatchers(HttpMethod.DELETE, "/checking/**").hasRole("ADMIN")

				.requestMatchers(HttpMethod.PUT, "/checking/**").hasRole("ADMIN")

				.requestMatchers(HttpMethod.POST, "/checking").hasRole("ADMIN")

				.requestMatchers(HttpMethod.DELETE, "/dealer/**").hasRole("ADMIN")

				.requestMatchers(HttpMethod.PUT, "/dealer/**").hasRole("ADMIN")

				.requestMatchers(HttpMethod.POST, "/dealer").hasRole("ADMIN")

				.requestMatchers(HttpMethod.DELETE, "/worker/**").hasRole("ADMIN")

				.requestMatchers(HttpMethod.PUT, "/worker/**").hasRole("ADMIN")

				.requestMatchers(HttpMethod.POST, "/worker").hasRole("ADMIN")

				// permission to others user and admin and all others who is authorize user

				.requestMatchers(HttpMethod.GET, "/checking").permitAll()

				.requestMatchers(HttpMethod.GET, "/dealer/**").permitAll()

				.requestMatchers(HttpMethod.GET, "/worker/**").permitAll()

				.requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

				.anyRequest()
//				.permitAll())
				.authenticated()).httpBasic(withDefaults()).build();
	}
}
