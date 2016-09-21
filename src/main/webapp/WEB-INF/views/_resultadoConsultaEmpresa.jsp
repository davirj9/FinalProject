<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	
	<table id="tableAjaxEmpresas" class="table table-hover">
		<thead>
				<tr>
					<th style="display: none;">Id</th>
					<th style="width: 2%">Id</th>
					<th style="width: 8%">Nome Empresa</th>
					<th style="width: 18%">Data de inclusão</th>
					<th style="width: 10%">Perfil da empresa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${empresas}" >
					<tr>
						<td>${e.idtEmpresa}</td>
						<td>${e.nomeEmpresa}</td>
						<td><fmt:formatDate value="${row.data_inclusao}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td>${e.perfilEmpresa}</td>
				    </tr>
				</c:forEach>
			</tbody>
	</table>
	</div>
	</div>	
	
	
</body>
</html>

