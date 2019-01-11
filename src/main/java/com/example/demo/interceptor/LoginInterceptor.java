package com.example.demo.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private List<String> excludedUrls;


	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {

		String requestUri = request.getRequestURI();


		for (String s : excludedUrls) {
			if (requestUri.endsWith(s)) {
				return true;
			}
		}

		Object uid =  request.getSession().getAttribute("loginInstId");
		if(uid == null || uid.equals("")){
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<script>");
			out.println("window.open ('/login.jsp','_top')");
			out.println("</script>");
			out.println("</html>");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

}
