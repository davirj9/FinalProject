<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TESTE Autocomplete</title>

<link href="http://fonts.googleapis.com/css?family=Open+Sans:600" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="webstuff/css/teste2.css"> 
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="webstuff/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/webstuff/js/teste/teste2.js"></script>
<script type="text/javascript" src="webstuff/js/jquery-ui.custom.min.js"></script>

</head>

<body>
	<div id="apresentacao">
		<h1>Google Maps API v3: Busca de endereço e Autocomplete</h1>
        <form method="post" action="index.html">
        <fieldset>
        <legend>Google Maps API v3: Busca de endereço e Autocomplete - Demo</legend>
		<div class="campos">
            <label for="txtEndereco">Endereço:</label>
            <input type="text" id="txtEndereco" name="txtEndereco" />
            <input type="button" id="btnEndereco" name="btnEndereco" value="Mostrar no mapa" />
		</div>
				<div id="mapa"></div>
                    <input type="submit" value="Enviar" name="btnEnviar" />
                    <input type="hidden" id="txtLatitude" name="txtLatitude" />
                    <input type="hidden" id="txtLongitude" name="txtLongitude" />
					<input type="hidden" id="txtEstado" name="txtEstado" />
					<input type="hidden" id="txtCidade" name="txtCidade" />
					<input type="hidden" id="txtPais" name="txtPais" />
                    </fieldset>
                    </form>
                    <div class="autores">
                    <p>Criado por:</p>
                    </div>
	</div>
</body>
</html>