<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TESTE</title>

<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/jquery.js"></script>
<script src="webstuff/js/bootstrap.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/webstuff/js/teste/teste.js"></script>

<link rel="stylesheet" href="webstuff/css/bootstrap.css">
<link rel="stylesheet" href="webstuff/css/bootstrap.min.css">
<link rel="stylesheet" href="webstuff/css/style.css">
<!-- Adicionando Javascript -->
</head>

<body>

	<label for="montadora">Montadora:</label>
	<select name="montadora" id="montadora">
		<option value="1">Fiat</option>
		<option value="2">Ford</option>
		<option value="3">Volkswagen</option>
	</select>
	<br />
	<label for="veiculo">Veículo:</label>
	<select name="veiculo" id="veiculo">
		<option value=""></option>
	</select>

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
		
		<form>

    <h2>Endereço de Residência</h2>

    <label for="cidadeResidencia">

	    <select id="cidadeResidencia" name="cidadeResidencia">

	        <option value="0" selected="selected"> - - ESCOLHA - - </option>

	        <option value="SAO PAULO">SÃO PAULO</option>

	        <option value="RIO DE JANEIRO">RIO DE JANEIRO</option>

	        <option value="BALNEARIO CAMBORIU">BALNEARIO CAMBORIU</option>

	    </select>

    </label>

    <h2>Endereço de Entrega</h2>

    <p>

    	Usar o mesmo endereço residencial para entrega?

    	<input type="radio" name="mesmoEndereco" value="sim" /> Sim

    	<input type="radio" name="mesmoEndereco" value="nao" checked="checked" /> Não

    </p>

    <label for="cidadeEntrega">

	    <select id="cidadeEntrega" name="cidadeEntrega">

	        <option value="SAO PAULO">SÃO PAULO</option>

	        <option value="RIO DE JANEIRO">RIO DE JANEIRO</option>

	        <option value="BALNEARIO CAMBORIU">BALNEARIO CAMBORIU</option>

	    </select>

    </label>

  </form>

</body>

</html>