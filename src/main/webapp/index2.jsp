<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="description" content="Find Here" />
<title>Find Here</title>
<meta name="description" content="Busque serviços de forma fácil">
<meta property="og:image" content="logo-snippet.png" />
<meta property="og:image:secure_url" content="logo-snippet.png" />
<link rel="icon" type="shortcut icon" href="favicon.ico" />

<link rel="stylesheet" href="webstuff/css/bootstrap.css">
<link rel="stylesheet" href="webstuff/css/bootstrap.min.css">
<link rel="stylesheet" href="webstuff/css/style2.css">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/webstuff/js/home/home.js"></script>

<style>
@media only screen and (min-width: 601px) {
	body.home.wrapper {
		background-image: url(webstuff/img/img-corpo.fw.png);
	}						
}
</style>

</head>
<body>
	<div class="menu" style="background-color: #ff7d7d">
	<%@ include file="WEB-INF/views/utils/_menu.jsp"%>
	</div>
	
	
	<div class="conteudo">
		<!--conteudo-->

		<div class="container-1">
			<h1>O QUE VOCÊ ESTÁ PROCURANDO?</h1>
			<div class="box" id="box1-address">
				
			<%@ include file="WEB-INF/views/consultaEmpresas/_consultaEmpresaNew.jsp"%>
				
			</div>
			<!-- fecha box-->

		</div>
		<!-- container-1 -->
	</div>
	<!--fecha conteudo-->
	
<%@ include file="WEB-INF/views/utils/footer.jsp"%>

</body>
</html>