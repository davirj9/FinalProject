/**
 * 
 */
package br.com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.dao.UsuarioDAO;
import br.com.project.modelo.Usuario;

/**
 * @author Maçana
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping("/efetuarLoginUsuario")
	public ModelAndView loginUsuario(Usuario usuario, HttpSession session) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		if(usuarioDAO.autenticaUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			modelAndView.setViewName("../../index2");
		}else
			modelAndView.setViewName("falha");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/usuarios")  
	 public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
	
		ModelAndView modelAndView = new ModelAndView("_tabelaUsuarios");
		
		modelAndView.addObject("usuarios", usuarioDAO.buscarUsuarios());
		
		return modelAndView;  
	  
	 }

}
