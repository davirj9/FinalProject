<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt" xml:lang="pt">
<meta charset="utf-8" />
<meta name="description" content="Find Here" />
<title>Cadastrar & Editar Empresas</title>
<link rel="alternate" hreflang="pt-BR" href="https://www.findhere.com.br/"/>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'/>


<head>	
	<%@ include file="../compartilhado/_base_css_js.jsp"%>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/webstuff/js/consultaEmpresas/cadastrarEditarEmpresa.js"></script>
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:600" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="webstuff/css/AutoComplete.css"> 
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false&key=AIzaSyAYUqPV-mmTDIzMmlejHQMq6En1LTm_3jc"></script>
	<script type="text/javascript" src="webstuff/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/webstuff/js/consultaEmpresas/consultaEmpresasNew.js"></script>
	<script type="text/javascript" src="webstuff/js/jquery-ui.custom.min.js"></script>
	<link rel="stylesheet" href="webstuff/css/style2.css">
		
</head>

<body>
	
<div class="global">
	<div class="menu">
		<%@ include file="../utils/_menu.jsp"%>
	</div>
	
	<div class="panel panel-default panelLogin center">
		<div class="panel-heading" style="background-color: #475E81;">
			<h5><b style="margin-left: 7px;">Cadastrar Empresas</b></h5>
		</div>
		<%@ include
			file="../consultaEmpresas/_cadastrarEmpresa.jsp"%>
	</div>
	
	<%@ include file="../utils/footer.jsp"%>
</div>
	
<script type="text/javascript" src="webstuff/js/home/home.js"></script>
</body>
</html>