package br.com.fametro.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		String uri = request.getRequestURI();
		if (uri.endsWith("/login.html") || uri.endsWith("/loginError.html")|| uri.endsWith("/autenticacao.html") || uri.contains("resources")) {
			return true;
		}
		
		if (uri.contains("/administrador/")) {
		
			if (request.getSession().getAttribute("adminAutenticado") != null) {
				return true;
			}
		}
		
		if (uri.contains("/professor/")) {
			
			if (request.getSession().getAttribute("profAutenticado") != null) {
				return true;
			}
		}

		response.sendRedirect("/login.html");
		return false;
	}

}
