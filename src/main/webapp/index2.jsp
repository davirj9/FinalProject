<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Find Here</title>	
<%@ include file="WEB-INF/views/compartilhado/_base_css_js.jsp"%>
</head>
<body>
	
	<div class="global">
	
		<div class="menu" style="background-color: #ff7d7d">
			<%@ include file="WEB-INF/views/utils/_menu.jsp"%>
		</div>
		
		<div class="conteudo">
			<div class="container-1">
				<h1>O QUE VOCÊ ESTÁ PROCURANDO?</h1>
				
				<a id="esconderMapa">Esconder</a>
				<a id="exibirMapa">Mostrar</a><br>
				<div id="divMapa">
					<%@ include
						file="WEB-INF/views/consultaEmpresas/_consultaEmpresaNew.jsp"%>
				</div>
				
				<a id="esconderEmpresas">Esconder</a>
				<a id="exibirEmpresas">Mostrar</a><br>
				<div id="divEmpresas">			
					<table id="tableAjaxEmpresas" class="table table-hover">
						<thead>
								<tr>
									<th style="display: none;">Id</th>
									<th style="width: 2%">Id</th>
									<th style="width: 8%">Nome Empresa</th>
									<th style="width: 13%">Endereço</th>
									<th style="width: 18%">Data de inclusão</th>
									<th style="width: 10%">Perfil da empresa</th>
								</tr>
						</thead>
						<tbody>
							<c:forEach var="e" items="${empresas}" >
								<tr>
									<td>${e.idtEmpresa}</td>
									<td>${e.nomeEmpresa}</td>
									<td>Estado: ${e.enderecoEmpresa.idtEstado.nomeEstado}
										Bairro: ${e.enderecoEmpresa.bairro}
										Logradouro: ${e.enderecoEmpresa.descricao_logradouro}
										${e.enderecoEmpresa.numero}</td>
									<td><fmt:formatDate value="${e.data_inclusao}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
									<td>${e.perfilEmpresa.descricaoPerfil}</td>
									<td><input class="visualizarEmpresa" title="Visualizar empresa" name="${e.idtEmpresa}" type="image" src="webstuff/img/icones/eye.png"></input>
									</td>
							    </tr>
							</c:forEach>
						</tbody>
					</table>
				</div>				
			
				
				<div id="DivResultadoEmpresa">
					<a id="esconderConsultaEmpresa">Esconder</a>
					<a id="exibirConsultaEmpresa">Mostrar</a><br>
					<div id="divConsultaEmpresas">
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
					</div>
				</div>
			</div>	
		</div>
		<%@ include file="WEB-INF/views/utils/footer.jsp"%>
	</div>
	
	<script type="text/javascript" src="webstuff/js/home/home.js"></script>
</body>
</html>