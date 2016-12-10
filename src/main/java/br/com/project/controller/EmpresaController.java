/**
 * 
 */
package br.com.project.controller;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import antlr.Utils;
import br.com.project.bo.EmpresaBO;
import br.com.project.dao.EmpresaDAO;
import br.com.project.dao.EnderecoEmpresaDAO;
import br.com.project.dao.PerfilEmpresaDAO;
import br.com.project.modelo.Empresa;
import br.com.project.modelo.EnderecoEmpresa;
import br.com.project.modelo.PerfilEmpresa;
import br.com.project.modelo.Usuario;
import br.com.project.util.BusinessException;
import br.com.project.util.Util;
import br.com.project.util.buscaEnderecoLatLong;
import br.com.project.vo.EmpresaVO;
import br.com.project.vo.EmpresaVO2;
import sun.rmi.transport.proxy.HttpReceiveSocket;

/**
 * @author Maçana
 *
 */
@Controller
public class EmpresaController extends buscaEnderecoLatLong{
	
	@Autowired
	private EmpresaDAO empresaDAO;
	
	@Autowired
	private EmpresaBO empresaBO;
	
	@Autowired
	private PerfilEmpresaDAO perfilEmpresaDAO;
	
	@Autowired
	private EnderecoEmpresaDAO enderecoEmpresaDAO;

	/*@RequestMapping(value="/teste")
	public String teste(){	
		return "teste";
	}*/
	
	@RequestMapping("/carregarFindHere")
	public ModelAndView carregarIndex(){
		ModelAndView modelAndView = new ModelAndView("index2"); 
		
		List<PerfilEmpresa> perfis = perfilEmpresaDAO.buscarPerfis();
		modelAndView.addObject("perfis", perfis);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/consultarEmpresas", method = RequestMethod.POST)
	 public String consultarEmpresas(Model model, HttpServletRequest request) throws JSONException, Exception{
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String raio = request.getParameter("raio");
		String perfil = request.getParameter("perfis");
		
		if(Util.isOk(latitude) && Util.isOk(longitude) && Util.isOk(raio) && Util.isOk(perfil)){
			Collection<EmpresaVO2> empresas = empresaBO.buscaEmpresasLatLong(latitude, longitude, raio, perfil);
			model.addAttribute("empresas", empresas);
			
		}if(!Util.isOk(latitude) && !Util.isOk(longitude) && !Util.isOk(raio)){
			throw new BusinessException("Favor, informar um endereço");
			
		}
		return "consultaEmpresas/_resultadoConsultaEmpresa";
	}
	
	@RequestMapping("/retornoEmpresa")
	@ResponseBody
	public void visualizarEmpresa(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "idtEmpresa", required = false) Integer idtEmpresa) throws JSONException, Exception{
		
		response.setContentType("application/json");
		PrintWriter out = null;
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {
			
			out = response.getWriter();
			JSONObject jSon = new JSONObject();
			
			Empresa empresa = empresaDAO.consultaPorIdt(idtEmpresa);
			
			hash.put("nome", empresa.getNomeEmpresa());
			hash.put("bairro", empresa.getEnderecoEmpresa().getBairro());
			hash.put("uf", empresa.getEnderecoEmpresa().getUf());
			hash.put("cep", empresa.getEnderecoEmpresa().getNumCep());
			hash.put("numero", empresa.getEnderecoEmpresa().getNumero());
			hash.put("descricao", empresa.getPerfilEmpresa().getDescricaoPerfil());
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, false);
			String retorno = mapper.writeValueAsString(hash);
			
			out = response.getWriter();
			jSon.put(retorno, retorno);
			out.println(retorno);

		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@RequestMapping("/editarCadastrarEmpresa")
	public String editarCadastrarEmpresa(HttpServletRequest request, Model model) throws Exception{
		try {
			HttpSession httpsession = request.getSession();
	        Usuario usuarioLogado = (Usuario) httpsession.getAttribute("usuarioLogado");
			
	        List<Empresa> empresas = empresaBO.retornaEmpresasPorUsuario(usuarioLogado);
	        
			List<PerfilEmpresa> perfis = perfilEmpresaDAO.buscarPerfis();
			model.addAttribute("perfis", perfis);
			model.addAttribute("empresas", empresas);
			
		}catch(Exception e){
			System.out.println(e);
		 }
	return "consultaEmpresas/cadastrarEditarEmpresa";
	}
	
	@RequestMapping("/cadastrarEmpresa")
	public String cadastrarEmpresa(HttpServletRequest request, Model model) throws Exception{
		try {
			buscaEnderecoLatLong enderecoLatLong = new buscaEnderecoLatLong();
			EmpresaVO empresaVO = new EmpresaVO();
			
			HttpSession httpsession = request.getSession();
	        Usuario usuarioLogado = (Usuario) httpsession.getAttribute("usuarioLogado");
	        empresaVO.setUsuarioLogado(usuarioLogado);
	        
			empresaVO.setLatitude(request.getParameter("latitude"));
			empresaVO.setLongitude(request.getParameter("longitude"));
			empresaVO.setIdtPerfil(Long.parseLong(request.getParameter("perfis")));
			empresaVO.setNomeEmpresa(request.getParameter("nomeEmpresa"));
			
			empresaVO = enderecoLatLong.getDados(empresaVO);
			
			empresaVO = empresaBO.adicionaEditaEmpresa(empresaVO);
			
			model.addAttribute("empresaVO", empresaVO);
			
			editarCadastrarEmpresa(request, model);
			
		}catch(Exception e){
			System.out.println(e);
		 }
	return "consultaEmpresas/cadastrarEditarEmpresa";
	}
	
	@RequestMapping("/excluirEmpresa")
	public void excluirEmpresa(HttpServletRequest request, Model model){
		String Idtempresa = request.getParameter("idtEmpresa");
		empresaBO.excluirEmpresa(Idtempresa);
		
		HttpSession httpsession = request.getSession();
        Usuario usuarioLogado = (Usuario) httpsession.getAttribute("usuarioLogado");
		
        List<Empresa> empresas = empresaBO.retornaEmpresasPorUsuario(usuarioLogado);
        
		List<PerfilEmpresa> perfis = perfilEmpresaDAO.buscarPerfis();
		model.addAttribute("perfis", perfis);
		model.addAttribute("empresas", empresas);
		
			
	}
	
	@RequestMapping("/voltarHome")
	public ModelAndView voltarHome(){
		ModelAndView modelAndView = new ModelAndView("index2"); 
		
		List<PerfilEmpresa> perfis = perfilEmpresaDAO.buscarPerfis();
		modelAndView.addObject("perfis", perfis);
		
		return modelAndView;
	}
	
	@RequestMapping("/editarEmpresa")
	public void editarEmpresa(HttpServletRequest request, Model model){
		
		String Idtempresa = request.getParameter("idtEmpresa");
		String CompEnd = request.getParameter("name");
		String nomeEmpresa = request.getParameter("nomeEmpresa"); 
		
		Empresa emrpesa = empresaDAO.consultaPorIdt(Integer.parseInt(Idtempresa));
		EnderecoEmpresa enderecoEmpresa = enderecoEmpresaDAO.consultaPorIdt(emrpesa.getEnderecoEmpresa().getIdtEndereco().intValue());
		
		emrpesa.setNomeEmpresa(nomeEmpresa);
		enderecoEmpresa.setComplemento_endereco(CompEnd);
		
		enderecoEmpresaDAO.salvar(enderecoEmpresa);
		empresaDAO.salvar(emrpesa);
	}
}
