<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="Pontos cardeais">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="webstuff/css/bootstrap.css">
<link rel="stylesheet" href="webstuff/css/bootstrap.min.css">
<link rel="stylesheet" href="webstuff/css/style.css">

	<script src="webstuff/js/jquery-1.10.1.min.js"></script>
    <script src="webstuff/js/jquery.js"></script>
	<script src="webstuff/js/bootstrap.js"></script>
	
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/webstuff/js/buscaCep/buscaCep.js"></script>
	
<title>FIND HERE</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<%
		Integer hitsCount = (Integer) application.getAttribute("hitCounter");
		if (hitsCount == null || hitsCount == 0) { /* First visit */
			//	out.println("<h2>SEJA BEM VINDO AO SISTEMA!</h2>"); 
			hitsCount = 1;
		}

		application.setAttribute("hitCounter", hitsCount);
	%>
	
	<div class="container"
		style="position: relative; margin: auto; top: 5em;">
		<!--Corpo do sistema-->
		<div class="hero-unit corpo">
			<div class="control_Pbtns">

				<h2>SEJA BEM VINDO AO SISTEMA!</h2>

				<p>FACA O SEU LOGIN OU CADASTRE CASO FOR NOVO POR AQUI.</p>
				<center>
					<p
						style="border: solid; width: 12em; position: relative; margin: auto; left: 472px; top: -158px; border-radius: 4px; border-color: rgba(81, 87, 102, 0.25);">
						Total de Visitas:
						<%=hitsCount%>
					</p>
				</center>

				<div style="position: relative; left: -34px;">
				<%@ include file="WEB-INF/views/cadastro/_cadastroDialog.jsp"%>
				<%@ include file="WEB-INF/views/login/_loginDialog.jsp"%>
				<%@ include file="WEB-INF/views/consultaEmpresas/_consultaEmpresaDialog.jsp"%>
				</div>
				
				
				<!--TESTE DO CRUD PARA BUSCAR USUARIOS-->
				<form class="navbar-form pull-right" id="buscarUsuarios"
					action="<%=request.getContextPath()%>/teste" method="POST">

					<button type="submit" class="btn btn-primary">
						<font><font>Pesquisar</font></font>
					</button>
				</form>
				<!--FIM TESTE DO CRUD PARA BUSCAS USUARIOS-->

			</div>
		</div>
	</div>
<!--Corpo do sistema-->

	<script>
		$(document).ready(function() {
			$('.dropdown-toggle').dropdown();
		});
	</script>


	<script type="text/javascript">
		$('#openBtn').click(function() {

			$('.modal-body').load('/render/62805', function(result) {
				$('#myModal').modal({
					show : true
				});
			});
		});
	</script>
	<%@ include file="WEB-INF/views/utils/footer.jsp"%>
</body>
</html>