
<script>
	$(function() {
		
		$("#dialog-retornoEmpresa").dialog({
			autoOpen : false,
			height : 600,
			width : 1000,
			modal : true
		});
		
	});
</script>

<!-- Inicio dialog movimentacao financeira -->
<div id="dialog-retornoEmpresa">

	<div class="semLabel"></div>
	<div id="naoExisteInfoAjaxRetornoEmpresa" style="text-align: center; display: none">Não
		existe informação cadastrada.</div>

	<script id="bodyTemplateAjaxRetornoEmpresa" type="text/x-jquery-tmpl">
				

		</script>

	<table id="tableAjaxRetornoEmpresa" class="table table-hover">
		<thead>
			<tr>
				<th>Teste</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	
	<div style="float: right; font-weight: bold;" id="mensagemTotalRetornoEmpresa"> </div>

</div>
<!-- Fim dialog Retorno Empresa -->