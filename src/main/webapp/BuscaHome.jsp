<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Find Here Teste Modal.</title>	
<%@ include file="WEB-INF/views/compartilhado/_base_css_js.jsp"%>
</head>
<body>

<a href="#" class="btn" id="openBtn"> Abrir Modal</a>
<button class="btn" id="openBtn2"> teste</button> 

<table id="tableAjaxEmpresa" class="table table-hover">
		<thead>
			<tr>
				<th>Nome Empresa</th>
				<th>Data de inclusão</th>
				<th>Perfil</th>
			</tr>
		</thead>
		<tbody id="bodyTemplateAjaxDadosEmpresa">
		
		</tbody>
</table>

<script type="text/javascript" src="webstuff/js/teste/teste2.js"></script>
</body>
</html>