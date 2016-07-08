<%@page import="br.com.project.modelo.Usuario"%>
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar</title>
<style type="text/css">
div#map_container{
	width:100%;
	height:350px;
}
</style>
</head>
<body
onload="loadMap()">
<div id="map_container"></div>
Teste
	<c:forEach var="u" items="${usuarios}" >
		<tr>
			<td>${u.idUsuario}</td>
			<td>${u.nomeUsuario}</td>
			<td>${u.emailUsuario}</td>
		</tr>
	</c:forEach>
	
	
</body>
</html>