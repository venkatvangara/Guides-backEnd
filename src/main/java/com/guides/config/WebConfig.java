package com.guides.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		// Forward ONLY Angular routes, NOT API routes
		registry.addViewController("/{path:^(?!api|guides|activities|users).*$}").setViewName("forward:/index.html");

		registry.addViewController("/**/{path:^(?!api|guides|activities|users).*$}").setViewName("forward:/index.html");
	}
}
