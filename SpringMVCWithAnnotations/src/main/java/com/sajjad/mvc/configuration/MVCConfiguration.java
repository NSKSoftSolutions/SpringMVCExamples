package com.sajjad.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(value="com.sajjad.mvc.controller")
@EnableWebMvc
public class MVCConfiguration {

	
	@Bean
	public InternalResourceViewResolver addInternal_View_Resolver()
	{
		InternalResourceViewResolver irv=new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/views/");
        irv.setSuffix(".jsp");
		
		return irv;
		
	}
	
	
	
	
	
}
