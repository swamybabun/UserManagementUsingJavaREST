
package com.fbk.usermanagement.application.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.fbk.usermanagement.application.*" })
@Import(value = { LoginSecurityConfig.class })
public class LoginApplicationConfig {

	private static Logger log = Logger.getLogger(LoginApplicationConfig.class);

	@Bean
	public InternalResourceViewResolver viewResolver() {
		log.debug("In View Resolver ");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
