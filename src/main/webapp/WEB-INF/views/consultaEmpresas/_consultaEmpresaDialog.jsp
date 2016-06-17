<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/jquery.js"></script>
<script src="webstuff/js/bootstrap.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/webstuff/js/consultaEmpresas/consultaEmpresas.js"></script>

<!-- Button trigger modal -->

	<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
		style="position: relative; top: 5px; left: 3em;" data-target="#myModalBuscarEmpresa">Pesquisar</button>


<!-- Modal Consulta empresa-->
<div id="myModalBuscarEmpresa" class="modal fade" role="dialog">
	<div class="modal-dialog">
	 <!-- Modal content-->
	 <div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">Consultar pelo Cep</h4>
		</div>
		<div class="modal-body">

			<form class="form-horizontal" id="pesquisaEmpresas"
				action="<%=request.getContextPath()%>/pesquisaEmpresas"
				method="POST">
				<label>Cep:
		        <input name="cep" type="text" id="cep" value="" size="10" maxlength="9" /></label>
		        <div>
		        <label>Estado:</label>
		        <select name="uf" id="uf">
					<option value="">Selecione</option>
					<option value="AC">AC</option>
					<option value="AL">AL</option>
					<option value="AM">AM</option>
					<option value="AP">AP</option>
					<option value="BA">BA</option>
					<option value="CE">CE</option>
					<option value="DF">DF</option>
					<option value="ES">ES</option>
					<option value="GO">GO</option>
					<option value="MA">MA</option>
					<option value="MG">MG</option>
					<option value="MS">MS</option>
					<option value="MT">MT</option>
					<option value="PA">PA</option>
					<option value="PB">PB</option>
					<option value="PE">PE</option>
					<option value="PI">PI</option>
					<option value="PR">PR</option>
					<option value="RJ">RJ</option>
					<option value="RN">RN</option>
					<option value="RS">RS</option>
					<option value="RO">RO</option>
					<option value="RR">RR</option>
					<option value="SC">SC</option>
					<option value="SE">SE</option>
					<option value="SP">SP</option>
					<option value="TO">TO</option>
				</select>
		        </div>
		        <label>Cidade:
		        <input name="cidade" type="text" id="cidade" size="40" /></label>
		        <label>Bairro:
		        <input name="bairro" type="text" id="bairro" size="40" /></label>
		        <label>Rua:
		        <input name="rua" type="text" id="rua" size="60" /></label>
		        <label>Número:
		        <input name="numero" type="text" id="rua" size="60" /></label>
				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn btn-success">Entrar</button>
					</div>
				</div>
			</form>

		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	</div>
</div>
</div>
</div>
<!-- Fim dialog busca empresa -->
