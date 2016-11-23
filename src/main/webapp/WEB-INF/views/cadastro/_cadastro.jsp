<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Find Here</title>
<%@ include file="../compartilhado/_base_css_js.jsp"%>

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
			<h5><b style="margin-left: 7px;">Cadastro Find Here</b></h5>
		</div>
		<div class="panel-body">
			<form id="formCadastroUser" method="post" action="efetuarCadastroUsuario">
				
				<div class="form-group">
				    <label for="email">Email address:</label>
				    <input type="email" class="form-control" id="email">
				</div>
				<div class="form-group">
				    <label for="nome">Nome:</label>
				    <input type="nome" class="form-control" id="nome">
				</div>
				<div class="form-group">
				    <label for="pwd">Password:</label>
				    <input type="password" class="form-control" id="pwd">
				</div>
			    <div class="checkbox">
			    	<label><input type="checkbox"> Remember me</label>
			    </div>
			    
				<h6>${msgErro}</h6>
				
				<input name="submit" value="Cadastrar" type="submit" class="btn btn-primary submitButton"/>
			</form>

		</div>
	</div>
</body>
</html>
	
<script>
$("input").blur(function(){
     if($(this).val() == ""){
    	 $(this).css({"border-color" : "#F00", "padding": "2px"});
     }else 
    	 $(this).css({"border-color" : "#FFFFFF", "padding": "2px"});
})
</script>