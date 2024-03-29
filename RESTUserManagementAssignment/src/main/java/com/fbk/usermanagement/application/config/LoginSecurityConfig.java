
package com.fbk.usermanagement.application.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.fbk.usermanagement.application.services.impl.UserService;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name = "userService")
	private UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authorities("ROLE_ADMIN");
		authenticationMgr.inMemoryAuthentication()
		        .withUser("peter@klaven")
		        .password("cityslicka")
		        .authorities("ROLE_ADMIN");
		userService.validateLogin("peter@klaven", "cityslicka");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		        .antMatchers("/homePage")
		        .access("hasRole('ROLE_ADMIN')")
		        .antMatchers("/user/*")
		        .access("hasRole('ROLE_ADMIN')")
		        .and()
		        .formLogin()
		        .loginPage("/loginPage")
		        .defaultSuccessUrl("/homePage")
		        .failureUrl("/loginPage?error")
		        .usernameParameter("username")
		        .passwordParameter("password")
		        .and()
		        .logout()
		        .logoutSuccessUrl("/loginPage?logout");
	}
}
