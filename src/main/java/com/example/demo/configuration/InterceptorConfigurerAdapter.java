package com.example.demo.configuration;

import com.example.demo.interceptor.CSRFInterceptor;
import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by lj on 2019/1/7.
 */
@Configuration
public class InterceptorConfigurerAdapter implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry){
//		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*.*").excludePathPatterns("/login");
//		registry.addInterceptor(new CSRFInterceptor()).addPathPatterns("/*.*").excludePathPatterns("/login");
	}
}
