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
	<!-- Registration form - START -->
	<div class="container">
		<form id="teste" method="post" action="teste">
        	<button value="Enviar" id="btnEnviar" ></button>
		</form>
        <input type="text" class="form-control" placeholder="teste" name="teste" value="${teste}">
	</div>
	<%@ include file="WEB-INF/views/utils/footer.jsp"%>
</div>
<script type="text/javascript" src="webstuff/js/teste/teste.js"></script>
</body>
</html>