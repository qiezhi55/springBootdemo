package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by lj on 2018/12/21.
 */
@Configuration
public class DefaultView implements WebMvcConfigurer {
	@Override
	public void addViewControllers( ViewControllerRegistry registry ) {
		registry.addViewController( "/" ).setViewName( "forward:/getInfo" );
		registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
	}
}
