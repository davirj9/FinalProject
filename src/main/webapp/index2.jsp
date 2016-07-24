<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="description" content="Find Here" />
<title>Find Here</title>
<meta name="description" content="Busque serviços de forma fácil">
<meta name="viewport" content="width=device-width, initial-scale=1"> <!--Para garantir a renderização adequada e sensíbilidade ao toque BOOTSTRAP-->
<meta property="og:image" content="logo-snippet.png" />
<meta property="og:image:secure_url" content="logo-snippet.png" />
<link rel="icon" type="shortcut icon" href="favicon.ico" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/bootstrap.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/bootstrap-select.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/jquery-ui.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/bootstrap-submenu.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/datepicker.css"
	type="text/css" />		
<link rel="stylesheet" href="webstuff/css/style2.css">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/webstuff/js/home/home.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<style>
@media only screen and (min-width: 601px) {
	body.home.wrapper {
		background-image: url(webstuff/img/img-corpo.fw.png);
	}
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
			
		$("a").click(function(event) {
			var link = $(this);

			if (link.attr("id").match("esconder"))
				$("#MeuDiv").hide("slow");
			else
				$("#MeuDiv").show("slow");

			event.preventDefault();

		});
		
		$("visualizarEmpresa").live({
			click : function(){
				$.ajax({
					url : "retornoEmpresa",
					type : "POST",
					cache : false,
					data : {
						idtEmpresa : idtEmpresa
					},
					success : function (data){
						
					}
				})
			}
		})
		 
	});
</script>

</head>
<body>
	
	<div class="global">
	
		<div class="menu" style="background-color: #ff7d7d">
			<%@ include file="WEB-INF/views/utils/_menu.jsp"%>
		</div>
		
		<a id="esconder">Esconder</a>
		<a id="exibir">Mostrar</a>
		
	
		<div class="conteudo">
			<div class="container-1">
				<h1>O QUE VOCÊ ESTÁ PROCURANDO?</h1>
					<div id="MeuDiv">
						<%@ include
							file="WEB-INF/views/consultaEmpresas/_consultaEmpresaNew.jsp"%>
					</div>		
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
									<td><input title="Visualizar empresa" name="${e.idtEmpresa}" type="image" data-toggle="modal" data-target="#myModalVisualizar" src="webstuff/img/icones/eye.png"></input>
									</td>
							    </tr>
							</c:forEach>
						</tbody>
				</table>				
			</div>
		</div>

	<!-- Modal Login-->
	<div id="myModalVisualizar" class="modal fade" role="dialog">
		<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Teste</h4>
			</div>
			<div class="modal-body">
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>
	
		<%@ include file="WEB-INF/views/utils/footer.jsp"%>
	</div>
</body>
</html>