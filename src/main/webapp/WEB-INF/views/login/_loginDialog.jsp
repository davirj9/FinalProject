<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Daniel Advogados</title>
<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/jquery.js"></script>
<script src="webstuff/js/bootstrap.js"></script>

<style type="text/css">
	body {
		background: #E9E9E9;
	}
	
	h5 {
		color: #FFF;
	}
	
	h6 {
		color: #FF0000;
	}
	.center {
		float: none;
		margin-left: auto;
		margin-right: auto;
	}
	
	.panelLogin {
		width: 400px;
	}
	
	.submitButton {
		float:right;
	}
	
	.linkSenha {
		float:right;
		margin-right: 15px;
	}
	
	.espacoTop {
		padding-top: 10px;
	}
</style>
</head>

<body>
	<div class="panel panel-default panelLogin center">
		<div class="panel-heading" style="background-color: #475E81;">
			<h5><b style="margin-left: 7px;">Login Find Here</b></h5>
		</div>
		<div class="panel-body">
			<form id="formLoginUser" method="post" action="efetuarLoginUsuario">
				<div class="input-group">
					<span class="input-group-addon"> 
					<img alt="Usuário" src="/webstuff/img/icones/usuario_20x20.png"> </span> 
					<input type="text"
						class="form-control" placeholder="Usuário" name="loginUsuario" value="${loginUsuario}">
				</div>
				<div class="espacoTop"></div>
				<div class="input-group">
					<span class="input-group-addon"><img alt="Usuário" src="/webstuff/img/icones/cadeado_20x20.png"></span> 
					<input type="password"
						class="form-control" placeholder="Senha" name="senhaUsuario" maxlength="8">
				</div>
				<div class="espacoTop"></div>
				
				<h6>${msgErro}</h6>
				
				<input name="submit" value="Efetuar Login" type="submit" class="btn btn-primary submitButton"/>
				<a href="#" class="linkSenha">Esqueci minha senha</a>
			</form>

		</div>
	</div>

</body>
</html>