/**
 * 
 */
package br.com.project.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.bo.EmpresaBO;
import br.com.project.dao.EmpresaDAO;
import br.com.project.dao.PerfilEmpresaDAO;
import br.com.project.modelo.Empresa;
import br.com.project.modelo.PerfilEmpresa;

/**
 * @author Maçana
 *
 */
@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaDAO empresaDAO;
	
	@Autowired
	private EmpresaBO empresaBO;
	
	@Autowired
	private PerfilEmpresaDAO perfilEmpresaDAO;
	/*@RequestMapping(value="/teste")
	public String teste(){	
		return "teste";
	}*/
	
	@RequestMapping("/carregarFindHere")
	public ModelAndView carregarIndex(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("../../index2"); 
		
		//List<PerfilEmpresa> perfis = perfilEmpresaDAO.buscarPerfis();
		//modelAndView.addObject("perfis", perfis);
		return modelAndView;
	}
	
	@RequestMapping(value="/consultarEmpresas", method = RequestMethod.POST)
	 public String consultarEmpresas(Model model, HttpServletRequest request) throws JSONException, Exception{
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		
		String estado = empresaBO.getEstado(latitude, longitude);
		
		List<Empresa> empresas = empresaDAO.buscarEmpresasPorFiltro(estado);
		
		model.addAttribute("empresas", empresas);
		
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
}
