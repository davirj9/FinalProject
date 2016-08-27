/**
 * 
 */
package br.com.project.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Maçana
 *
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) 
	throws Exception{
		
		String uri = request.getRequestURI();
		if(uri.endsWith("index2")){
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLogado")!=null){
			return true;
		}else {
			response.sendRedirect("falha");
			return false;
		}
	}

}
