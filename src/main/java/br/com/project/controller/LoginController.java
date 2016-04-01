package br.com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	@RequestMapping("efetuarLoginUsuario")
	public ModelAndView efetuarLogin(HttpServletRequest request, HttpServletResponse response,
									@RequestParam(value="login", required=true)String email_usuario,
									@RequestParam(value="senha", required=true)String senhaUsuario){
		ModelAndView modelAndView = new ModelAndView("princ");
		
		
		return modelAndView;
	}
	
}
