<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
session.removeAttribute("abre_secao");//* o nome da sessao que esta aberto na pagina "princ.jsp" aki ele remove a sessao
session.invalidate();// esse termina a sessao ou seja destroi completamente a sessao
response.sendRedirect("index.jsp"); // direciona automaticamente para a pagina index.jsp 
%>

