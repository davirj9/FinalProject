<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"><!--<![endif]-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt" xml:lang="pt">
<meta charset="utf-8" />
<meta name="description" content="Find Here" />
<title>Find Here</title>
<link rel="alternate" hreflang="pt-BR" href="https://www.findhere.com.br/"/>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'/>
<link rel="stylesheet" href="webstuff/css/style2.css">

<meta name="theme-color" content="#bc2026"/>
			<!--<style>
				@media only screen and (min-width: 601px){
					body.home .pac-geral .content { 
						background-image: url(img-corpo.fw.png);
					}
				}
				@media only screen and (max-width: 600px){
					body.home .pac-geral .content { 
						background-image: url(img-corpo.fw.png);
					}
				}
			</style>-->

<head>	
<%@ include file="WEB-INF/views/compartilhado/_base_css_js.jsp"%>
</head>
<body>
	
	<div class="global">
	
		<div class="menu">
			<%@ include file="WEB-INF/views/utils/_menu.jsp"%>
		</div>
		
		<a id="esconderMapa">Esconder Mapa</a><br>
		<a id="exibirMapa">Mostrar Mapa</a><br>
		
		<div class="conteudo">
			<div class="box box1">
				<h1>O QUE VOCÊ ESTÁ PROCURANDO?</h1>
				
				<div id="MeuDiv">
					<%@ include
						file="WEB-INF/views/consultaEmpresas/_consultaEmpresaNew.jsp"%>
				</div>
				
				<a id="esconderEmpresas">Esconder Empresas</a><br>
				<a id="exibirEmpresas">Mostrar Empresas</a>
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
									<td>Estado: ${e.enderecoEmpresa.uf}
										Bairro: ${e.enderecoEmpresa.bairro}
										Logradouro: ${e.enderecoEmpresa.descricao_logradouro}
										${e.enderecoEmpresa.numero}</td>
									<td><fmt:formatDate value="${e.data_inclusao}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
									<td>${e.perfilEmpresa.descricaoPerfil}</td>
									<td><input class="visualizarEmpresa" title="Visualizar empresa" name="${e.idtEmpresa}" type="image" src="webstuff/img/icones/eye.png"></input></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>	
				</div>			
					
				<a id="esconderConsultaEmpresa">Esconder</a>
				<a id="exibirConsultaEmpresa">Mostrar</a><br>
				<div id="DivResultadoEmpresa">
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