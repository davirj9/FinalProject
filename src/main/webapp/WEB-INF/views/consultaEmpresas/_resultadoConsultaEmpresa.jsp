<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table id="tableAjaxEmpresas" class="table table-hover">
	<thead>
		<tr>
			<th style="display: none;">Id</th>
			<th style="width: 8%">Nome Empresa</th>
			<th style="width: 13%">Bairro:</th>
			<th style="width: 18%">Distância:</th>
			<th style="width: 10%">Perfil da empresa</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${empresas}" >
			<tr>
				<td>${e.nomeEmpresa}</td>
				<td>${e.bairro}</td>
				<td>${e.distancia}</td>
				<td>${e.descricaoPerfil}</td>
				<td><input class="visualizarEmpresa" title="Visualizar empresa" name="${e.idtEmpresa}" type="image" src="webstuff/img/icones/eye.png"></input></td>
			</tr>
		</c:forEach>
	</tbody>
</table>