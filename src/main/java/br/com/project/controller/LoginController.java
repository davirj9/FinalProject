package br.com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.login.AutenticaLogin;

@Controller
public class LoginController {
	
	@Autowired
	private AutenticaLogin autenticaLogin;
	
	
	@RequestMapping("/efetuarLoginUsuario")
	public ModelAndView logar(HttpServletRequest request, HttpServletResponse response,
					  @RequestParam(value = "login", required = true) String login,
					  @RequestParam(value = "senha", required = true) String senha){
		ModelAndView modelAndView = new ModelAndView();
		
		try{
			if(login.equals("admin") && senha.equals("senha"))
				modelAndView.setViewName("princ");
			else{
				modelAndView.addObject("msgErro","Login ou senha inválidos");
				modelAndView.setViewName("princ");
			}
		}catch(Exception e){
			modelAndView.addObject("msgErro", "Ocorreu um erro ao tentar efetuar a operação");
			modelAndView.setViewName("index");
		}
		return modelAndView;		
	}
}
