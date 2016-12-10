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
	
	<div class="panel panel-default panelLogin center">
		<div class="panel-heading" style="background-color: #475E81;">
			<h5><b style="margin-left: 7px;">Editar Empresas</b></h5>
		</div>
		
		<table class="table">
			
		</table>
		<table class="table" border="1">	
			<tbody>
				<thead>
					<tr>
						<th>Nome Empresa</th>
						<th>Bairro</th>
						<th>UF</th> 
						<th>Descrição Logradouro</th>
						<th>Complemento</th>
						<th>Número</th>
						<th>Cep</th>
						<th>Perfil</th>
					</tr> 
					<c:forEach var="e" items="${empresas}" >
						<tr style="background: #E4FAFF;">
							<th><input type="text" id="nomeEmpresa" class="editarEmpresa" name="${e.idtEmpresa}" value="${e.nomeEmpresa}"/></th>
							<th>${e.enderecoEmpresa.bairro}</th>
							<th>${e.enderecoEmpresa.uf}</th>
							<th>${e.enderecoEmpresa.descricao_logradouro}</th>
							<th><input type="text" id="compEnd" class="editarEmpresa" name="${e.idtEmpresa}" value="${e.enderecoEmpresa.complemento_endereco}"/></th>
							<th>${e.enderecoEmpresa.numero}</th>
							<th>${e.enderecoEmpresa.numCep}</th>
							<th><select name="idtPerfis" id="idtPerfis" class="selectpicker">
									<option value="<c:out value="${e.perfilEmpresa.idtPerfil}"/>" data-subtext="<c:out value="${e.perfilEmpresa.descricaoPerfil}"/>"><c:out value="${e.perfilEmpresa.descricaoPerfil}" /></option>
								</select>
							</th>
							<th><button type="button" id="excluirEmpresa" class="excluirEmpresa" name="${e.idtEmpresa}">
									<i class="glyphicon glyphicon-remove"></i>
								</button>
							</th>
						</tr>
					</c:forEach>
				</thead>		
			</tbody>
		</table>
	</div>
	<%@ include file="../utils/footer.jsp"%>
</div>
	
<script type="text/javascript" src="webstuff/js/home/home.js"></script>
</body>
</html>