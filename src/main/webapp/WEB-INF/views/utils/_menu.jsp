<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<meta charset="utf-8">
<meta name="description" content="Find Here">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="webstuff/css/bootstrap.css">
<link rel="stylesheet" href="webstuff/css/bootstrap.min.css">
<%@ include file="../compartilhado/_base_css_js.jsp"%>

<script type="text/javascript" src="webstuff/js/menu/menu.js"></script>

<span class="img-responsive"><img src="webstuff/img/logo.fw.png" /></span>

<c:choose>
  <c:when test="${empty usuarioLogado}">
	<button type="button" id="carregarCadastro" class="btn btn-mini btn-primary" action="">Cadastrar
		<i class="icon-off"></i>
	</button>
	<button type="button" id="carregarLogin" class="btn btn-mini btn-danger" action="carregarLogin" >Login
		<i class="icon-off"></i>
	</button>
  </c:when>
  <c:otherwise>
 	 <button type="button" id="editarCadastrarEmpresa" class="btn btn-mini btn-primary" action="editarCadastrarEmpresa">Editar/Cadastrar Empresa
		<i class="glyphicon glyphicon-pencil"></i>
	</button>
	<button type="button" id="deslogarUsuario" class="btn btn-mini btn-danger" action="deslogarUsuario" >Sair
		<i class="icon-off"></i>
	</button>
  </c:otherwise>
</c:choose>