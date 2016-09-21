package br.com.project.util;

import java.io.IOException;

public class testeBuscaCep {

	public static void main(String[] args) throws IOException {
		
		buscaCEP buscacep = new buscaCEP();  
		
		String CEP = "21331240";
		
		String end = buscacep.getBairro(CEP);
		
		System.out.println(CEP);
	}
}
