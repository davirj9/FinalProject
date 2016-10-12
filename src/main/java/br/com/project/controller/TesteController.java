package br.com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.project.dao.EmpresaDAO;
import br.com.project.modelo.Empresa;

@Controller
public class TesteController {
	
	@Autowired
	private EmpresaDAO empresaDAO;
	
	@RequestMapping("teste")
	public void teste(HttpServletRequest request, HttpServletResponse response){
		String teste = "teste";
		request.setAttribute("teste", teste);
	}
	
	
}
