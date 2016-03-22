package br.com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.media.jfxmedia.logging.Logger;

import br.com.project.login.AutenticaLogin;
import br.com.project.login.SecurityUser;
import sun.text.normalizer.ICUBinary.Authenticate;

@Controller
public class LoginController {
	
	@Autowired
	private AutenticaLogin autenticaLogin;
	
	@RequestMapping("/efetuarLoginUsuario")
	public ModelAndView logar(HttpServletRequest request, HttpServletResponse response,
					  @RequestParam(value = "login", required = true) String login,
					  @RequestParam(value = "senha", required = true) String senha){
		ModelAndView modelAndView = new ModelAndView();
		
		//LOGGER.info("Efetudando o login do usuário: " + login);
		
		try{
			boolean isLogin = autenticaLogin.login(login.toLowerCase(), senha);
			
			if(isLogin){
				SecurityUser securityUser = autenticaLogin.getUserLogged();
				modelAndView.setViewName("princ");
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("usuarioLogado", securityUser.getUsuario());
				
				//Logger.INFO("Usuário"+ securityUser.getUsername() + "efetuou o login.");
			}else{
				modelAndView.addObject("login", login.toLowerCase());
				modelAndView.addObject("msgErro","Login ou senha incorreto");
				modelAndView.setViewName("index");
				
				//LOGGER.info("Ocorreu um erro ao tentar logar o usuario: " + login);
			}		
		}catch(Exception e){
			modelAndView.addObject("msgErro", "Algum erro interrompeu a operação");
			modelAndView.setViewName("index");
		}
		return modelAndView;		
	}
}
