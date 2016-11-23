<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="http://fonts.googleapis.com/css?family=Open+Sans:600" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="webstuff/css/AutoComplete.css"> 
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false&key=AIzaSyAYUqPV-mmTDIzMmlejHQMq6En1LTm_3jc"></script>
<script type="text/javascript" src="webstuff/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/webstuff/js/consultaEmpresas/consultaEmpresasNew.js"></script>
<script type="text/javascript" src="webstuff/js/jquery-ui.custom.min.js"></script>
<link rel="stylesheet" href="webstuff/css/style2.css">


	<div id="apresentacao">
        <form id="consultarEmpresas">
        <fieldset>
			<div class="campos">
            	<label for="txtEndereco">Endereço:</label>
           		<input type="text" id="txtEndereco" name="txtEndereco" />
           		<input type="button" id="btnEndereco" name="btnEndereco" value="Mostrar no mapa" />
			</div>
			
			<input type="radio" name="radioRaio" value="2"/> 2km <br />
			<input type="radio" name="radioRaio" value="5"/> 5km <br />
			<input type="radio" name="radioRaio" value="8"/> 8KM <br />
			
			<div class="input input-group-sm">
				<select name="idtPerfis" id="idtPerfis" class="selectpicker">
					<c:forEach var="row" items="${perfis}" varStatus="i">
						<option value="<c:out value="${row.idtPerfil}"/>" data-subtext="<c:out value="${row.descricaoPerfil}"/>"><c:out value="${row.descricaoPerfil}" /></option>
					</c:forEach>
				</select>
			</div>
			
			<div id="mapa"></div>  
			<br>	
			
	        <input type="image" value="Enviar" id="btnEnviar" class="btnEnviar" name="btnEnviar" 
				value="Enviar" src="webstuff/img/buscar.fw.png"></input>
			<input type="hidden" id="txtLatitude" name="txtLatitude" />
	        <input type="hidden" id="txtLongitude" name="txtLongitude" />
	        
		</fieldset>
        </form>
	</div>