<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Cadastro</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<%@ include file="WEB-INF/views/compartilhado/_base_css_js.jsp"%>
    
<style type="text/css">

.container {
	position: center;
	height: 400px;
  	width: 40%;
	background-color:#C0C0C0;
    border-radius: 10px;
}	
.form-group{
	position: center;
}
 
</style>

</head>
<body>
<div class="global">
	<div class="container">

		<!-- Registration form - START -->
		<div class="container">
		    <div class="row">
		        <form role="form" id="efetuarCadastroUsuario">
		            <div class="col-lg-6">
		                <div class="form-group">
		                    <label for="InputName">Nome</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" name="InputNome" id="InputNome" placeholder="Nome" required>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="InputEmail">Email</label>
		                    <div class="input-group">
		                        <input type="email" class="form-control" id="InputEmailFirst" name="InputEmail" placeholder="Email" required>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="InputEmail">Confirmar Email</label>
		                    <div class="input-group">
		                        <input type="email" class="form-control" id="InputEmailSecond" name="InputEmail" placeholder="Confirmar Email" required>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="InputEmail">Senha</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" id="InputSenha" name="InputSenha" placeholder="Senha" required>
		                    </div>
		                </div>
		                </br>
		                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-left">
		            </div>
		        </form>
		    </div>
		</div>
		<!-- Registration form - END -->
	</div>
	<%@ include file="WEB-INF/views/utils/footer.jsp"%>
</div>
<script type="text/javascript" src="webstuff/js/teste/teste.js"></script>
</body>
</html>