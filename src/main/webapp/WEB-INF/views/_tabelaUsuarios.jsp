<%@page import="br.com.project.modelo.Usuario"%>
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar</title>
<style type="text/css">
div#map_container{
	width:100%;
	height:350px;
}
</style>
<script type="text/javascript" 
   src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<%double lat = 4.3695030; 
  double lon = 101.1224120;%>
<script type="text/javascript">
  function loadMap() {
    var latlng = new google.maps.LatLng(<%=lat%>, <%=lon %>);
    var myOptions = {
      zoom: 4,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
	
    var marker = new google.maps.Marker({
      position: latlng, 
      map: map, 
      title:"my hometown, Malim Nawar!"
    }); 
  
  }
</script>
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