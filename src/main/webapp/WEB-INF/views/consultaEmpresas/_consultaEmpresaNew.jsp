<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>TESTE Autocomplete</title>

<link href="http://fonts.googleapis.com/css?family=Open+Sans:600" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="webstuff/css/AutoComplete.css"> 
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="webstuff/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/webstuff/js/consultaEmpresas/consultaEmpresasNew.js"></script>
<script type="text/javascript" src="webstuff/js/jquery-ui.custom.min.js"></script>


	<div id="apresentacao">
        <form id="FormBuscaMap" method="post" action="index.html">
        <fieldset>
		<div class="campos">
            <label for="txtEndereco">Endereço:</label>
            <input type="text" id="txtEndereco" name="txtEndereco" />
            <input type="button" id="btnEndereco" name="btnEndereco" value="Mostrar no mapa" />
            
		</div>
				<div id="mapa"></div>
					
					<select name="">
						<option value="farmacia">Farmácia</option>
						<option value="farmacia">Farmácia</option>
						<option value="farmacia">Farmácia</option>
					</select> 
                    <input type="image" value="Enviar" id="btnEnviar" name="btnEnviar" 
					value="Enviar" src="webstuff/img/buscar.fw.png"></input>
					<input type="hidden" id="txtLatitude" name="txtLatitude" />
                    <input type="hidden" id="txtLongitude" name="txtLongitude" />
					<input type="hidden" id="txtEstado" name="txtEstado" />
					<input type="hidden" id="txtCidade" name="txtCidade" />
					<input type="hidden" id="txtPais" name="txtPais" />
					
                    </fieldset>
                    </form>
	</div>