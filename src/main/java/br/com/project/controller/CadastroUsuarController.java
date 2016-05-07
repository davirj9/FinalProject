package br.com.project.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.bo.UsuarioBO;
import br.com.project.boimpl.UsuarioBOImpl;
import br.com.project.modelo.Usuario;
import br.com.project.util.RetornoGenericoVO;
import br.com.project.util.buscaCEP;

@Controller
public class CadastroUsuarController {
	
	@Autowired
	private UsuarioBO usuarioBO;
	
	@RequestMapping("efetuarCadastroUsuario")
	public ModelAndView cadastroUsuario(HttpServletRequest request , HttpServletResponse response,
										@RequestParam(value="nome", required=true)String nomeUsuario,
										@RequestParam(value="email", required=true)String emailUsuario,
										@RequestParam(value="password", required=true) String senhaUsuario){
		ModelAndView modelAndView = new ModelAndView("index");
	
		Usuario usuario = new Usuario();
		
		usuario.setNomeUsuario(nomeUsuario);
		usuario.setEmailUsuario(emailUsuario);
		usuario.setSenhaUsuario(senhaUsuario);
		//usuario.setIdUsuario(1);
		
		//RetornoGenericoVO retornoGenericoVO = usuarioBO.gravarNovoUsuario(usuario);
		usuarioBO.gravarNovoUsuario(usuario);
		
		return modelAndView;
	}
	
	@RequestMapping("buscarUsuarios")
    public ModelAndView buscarUsuarios(HttpServletRequest request, HttpServletResponse response){
									   //@RequestParam(value="nomeUsuario", required = false) String nomeUsuario,
									   //@RequestParam(value="emailUsuario", required = false) String emailUsuario){
		ModelAndView modelAndView = new ModelAndView("_tabelaUsuarios");
		
		Collection<Usuario> usuarios = usuarioBO.buscarUsuarios();
		
		/*for (Iterator<Usuario> i =  usuarios.iterator(); i.hasNext(); )
		{
			// pegue elemento por elemnto da lista a cada iteração do laço
			Usuario u = i.next();
			// use e abuse
			System.out.println(u.getNomeUsuario());
		}*/
		
		//model.addAttribute(usuarios);
		modelAndView.addObject("usuarios", usuarios);
		
		return modelAndView;
		//return "_tabelaUsuarios";
	}
	
	@RequestMapping("pesquisaEmpresas")
	public ModelAndView cadastroUsuario(HttpServletRequest request , HttpServletResponse response,
										@RequestParam(value="CEP", required=true)String CEP) throws IOException{
		ModelAndView modelAndView = new ModelAndView("index");
	
		buscaCEP buscacep = new buscaCEP();
		
		String UF = buscacep.getUF(CEP);
		String cidade = buscacep.getCidade(CEP) ;
		String bairro = buscacep.getBairro(CEP);
		String endereco = buscacep.getEndereco(CEP);
		
		modelAndView.addObject("UF", UF);
		modelAndView.addObject("cidade", cidade);
		modelAndView.addObject("bairro", bairro);
		modelAndView.addObject("endereco", endereco);
		
		return modelAndView;
	}
}
