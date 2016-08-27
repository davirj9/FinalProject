/**
 * 
 */
package br.com.project.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Maçana
 *
 */
public class buscaEnderecoLatLong {
	public String getEstado(String Latitude, String Longitude) throws IOException{
		
		Document doc = Jsoup
				.connect("//maps.google.com/maps/api/geocode/json?address="+Latitude+","+Longitude+"&sensor=false.")
				.timeout(120000).get();
		
		Elements urlPesquisa = doc.select("");
		
		String estado = null;
		return estado; 
	}

}
