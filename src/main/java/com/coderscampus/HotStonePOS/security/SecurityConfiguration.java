package com.coderscampus.HotStonePOS.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration()
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth
//  			.userDetailsService(userDetailsService)
//			.passwordEncoder(passwordEncoder);
		
		auth
		.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder)
		.withUser("mfahmy")
		.password("$2a$10$REHIn.mDCpU1.hNHdyPY2eTE2AWphoYZkQ2aoS35UIj.jGpvs9B.i") //password123
		.roles("USER", "ADMIN");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.anyRequest().hasAnyRole("USER").and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/dashboard")
			.permitAll();	
	}
	
	
}
