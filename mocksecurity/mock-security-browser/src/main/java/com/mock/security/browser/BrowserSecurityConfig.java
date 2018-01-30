package com.mock.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mock.security.core.properties.SecurityProperties;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Bean
	public  PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic()	// Authenticate in an alert window (default)
//		http.formLogin()   //User the default form page of SpringSecurity to authenticate.Username is "user",password is the default when tomcat starts.(Configure a class extending WebSecurityConfigurerAdapter and overwriting this method is all, no need to write a login page)			
//			.and()
//			.authorizeRequests()
//			.anyRequest()
//			.authenticated();
		
//		http.formLogin()
//		.loginPage("/mock-signIn.html")
//		.loginProcessingUrl("/authentication/form") //The default url defined in UsernamePasswordAuthenticationFilter is "/login",
//		.and()
//		.authorizeRequests()
//		.antMatchers("/mock-signIn.html").permitAll() //"err too many redirects" will occur without this line
//		.anyRequest()
//		.authenticated()
//		.and()
//		.csrf().disable();
		
		http.formLogin()
		.loginPage("/authentication/require")
		.loginProcessingUrl("/authentication/form")
		.and()
		.authorizeRequests()
		.antMatchers("/authentication/require",securityProperties.getBrowser().getLoginPage()).permitAll() //"Too many redirection times" error will occur without this line
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable();
	}
	
	
}
