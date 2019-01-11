package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by lj on 2019/1/7.
 */
@Component
@WebFilter(urlPatterns = "/*" ,filterName = "xssfilter")
public class XssFilter implements Filter {
	private static Logger logger = LoggerFactory.getLogger(XssFilter.class);
	public static boolean ISOPEN = true;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器创建");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		if(ISOPEN){
			logger.debug("xss filter is open");
			XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper( (HttpServletRequest) request);
			filterChain.doFilter(xssRequest, response);
		}else{
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}
}
