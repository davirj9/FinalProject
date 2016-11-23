/**
 * 
 */
package br.com.project.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.dao.PerfilEmpresaDAO;
import br.com.project.dao.UsuarioDAO;
import br.com.project.modelo.PerfilEmpresa;
import br.com.project.modelo.Usuario;

/**
 * @author Maçana
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private PerfilEmpresaDAO perfilEmpresaDAO;
	
	@RequestMapping("/carregarLogin")
	public String carregarLogin(Usuario usuario, HttpSession session) throws Exception{
		return "login/_login";
	}
	
	@RequestMapping("/efetuarLoginUsuario")
	public String loginUsuario(Usuario usuario, HttpServletRequest request, Model model) throws Exception{
		if(usuarioDAO.autenticaUsuario(usuario)){
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			model.addAttribute("usuarioLogado",usuario.getEmailUsuario().toUpperCase());
			List<PerfilEmpresa> perfis = perfilEmpresaDAO.buscarPerfis();
			model.addAttribute("perfis", perfis);
			return "../../index2";
		}	
		else{
			model.addAttribute("msgErro","Usuário ou senha informado é inválido.");
			return "login/_login";
		}
	}
	
	@RequestMapping("/deslogarUsuario")
	public String deslogarUsuario(HttpServletRequest request, Model model) throws Exception{
		try {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", null);
			model.addAttribute("usuarioLogado", null);
			
		}catch(Exception e){
			System.out.println(e);
		 }
	return "../../index2";
	}
}
