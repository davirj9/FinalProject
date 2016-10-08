/**
 * 
 */
package br.com.project.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("/carregarLogin")
	public String carregarLogin(Usuario usuario, HttpSession session) throws Exception{
		return "login/_login";
	}
	
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
	
	@RequestMapping("/carregarCadastro")
	public String carregarCadastro(HttpServletRequest request, HttpServletResponse response){
		
		return "cadastro/_cadastroDialog.jsp";
	}
	
	public @ResponseBody void cadastroUsuario(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "nome", required = true) String nome,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "senha", required = true) String senha) throws Exception{
	
		response.setContentType("application/json");
		PrintWriter out = null;
		
		try{
			out = response.getWriter();
			JSONObject jSon = new JSONObject();
			
			String mensagem = "teste";
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
			String retorno = mapper.writeValueAsString(mensagem);
			
			out = response.getWriter();
			jSon.put(retorno, retorno);
			out.println(retorno);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@RequestMapping(value="/usuarios")  
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
	
		ModelAndView modelAndView = new ModelAndView("_tabelaUsuarios");
		
		modelAndView.addObject("usuarios", usuarioDAO.buscarUsuarios());
		
		return modelAndView;
	}
}
