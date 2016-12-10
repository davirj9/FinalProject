<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="http://fonts.googleapis.com/css?family=Open+Sans:600" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="webstuff/css/AutoComplete.css"> 
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false&key=AIzaSyAYUqPV-mmTDIzMmlejHQMq6En1LTm_3jc"></script>
<script type="text/javascript" src="webstuff/js/jquery.min.js"></script>

<script type="text/javascript" src="webstuff/js/jquery-ui.custom.min.js"></script>
<link rel="stylesheet" href="webstuff/css/style2.css">


<div id="apresentacao">
	<form id="consultarEmpresas">
		<fieldset>
			<div class="campos">
				<div class="input input-group-sm">
				<b>Perfil da Empresa:</b> <br>
					<select name="idtPerfis" id="idtPerfis" class="selectpicker">
						<c:forEach var="row" items="${perfis}" varStatus="i">
							<option value="<c:out value="${row.idtPerfil}"/>" data-subtext="<c:out value="${row.descricaoPerfil}"/>"><c:out value="${row.descricaoPerfil}" /></option>
						</c:forEach>
					</select>
				</div> <br>
				
				<b>Nome da Empresa:</b> <br>
				<input type="text" id="txtNomeEmp" name="txtNomeEmp" /> <br><br>
				
				<b>Endereço da Empresa:</b> <br>
				<input type="text" id="txtEndereco" name="txtEndereco" /> <br><br>
				
				<b>Complemento Endereço:</b> <br>
				<input type="text" id="txtComplEnd" name="txtComplEnd" /> <br><br>
				
			</div>
				
			<div id="mapa"  style="display: none;"></div>  
						
			<input type="submit" value="Cadastrar" id="btnCadastrar" class="btn btn-mini btn-primary" name="btnCadstrar"></input>
			<input type="hidden" id="txtLatitude" name="txtLatitude" />
			<input type="hidden" id="txtLongitude" name="txtLongitude" />		      
		</fieldset>
	</form>
	<form id="voltarHome">
			<input type="submit" value="Voltar" action="voltarHome" class="btn btn-mini btn-primary" name="voltarHome"></input>
	</form>			
</div>