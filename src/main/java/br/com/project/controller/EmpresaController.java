/**
 * 
 */
package br.com.project.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.dao.EmpresaDAO;
import br.com.project.dao.EstadoDAO;
import br.com.project.modelo.Empresa;
import br.com.project.modelo.Estado;

/**
 * @author Maçana
 *
 */
@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaDAO empresaDAO;
	
	@Autowired
	private EstadoDAO estadoDAO;
	
	@RequestMapping(value="/teste")
	public String teste(){
		return "teste";
	}
	
	@RequestMapping("/carregarFindHere")
	public ModelAndView carregarIndex(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("../../index2"); 
		String uf = "RJ";
		Estado estado = estadoDAO.buscaEstado(uf);
		modelAndView.addObject("empresas", empresaDAO.buscarEmpresasPorFiltro(estado));		
		return modelAndView;
	}
	
	@RequestMapping(value="/consultarEmpresas")
	 public ModelAndView consultarEmpresas(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("../../index2");
				
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		
		
		String uf = "RJ";
		Estado estado = estadoDAO.buscaEstado(uf);
		
		modelAndView.addObject("empresas", empresaDAO.buscarEmpresasPorFiltro(estado));
		
		return modelAndView;
	}
	
	@RequestMapping(value="/retornoEmpresa")
	public @ResponseBody void visualizarEmpresa(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "idtEmpresa", required = false) Integer idtEmpresa) throws Exception{
		
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			
			out = response.getWriter();
			JSONObject jSon = new JSONObject();
			
			Empresa empresa = empresaDAO.consultaPorIdt(idtEmpresa);
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
			String retorno = mapper.writeValueAsString(empresa);
			
			out = response.getWriter();
			jSon.put(retorno, retorno);
			out.println(retorno);

		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
