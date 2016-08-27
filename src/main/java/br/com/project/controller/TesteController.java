package br.com.project.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import br.com.project.bo.EmpresaBO;
import br.com.project.dao.EmpresaDAO;
import br.com.project.dao.EstadoDAO;
import br.com.project.dao.UsuarioDAO;
import br.com.project.modelo.Empresa;
import br.com.project.modelo.Estado;
import br.com.project.modelo.Usuario;

@Controller
public class TesteController {
	
	
}
