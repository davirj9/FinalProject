<html lang="pt">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Nome da página</title>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/bootstrap.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/bootstrap-select.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/jquery-ui.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/bootstrap-submenu.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webstuff/css/datepicker.css"
	type="text/css" />
<link rel="stylesheet" href="webstuff/css/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<head>
<title>Matheus Piscioneri</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(document).ready(function() {
			
		$("a").click(function(event) {
			var link = $(this);

			if (link.attr("id").match("esconder"))
				$("#MeuDiv").hide("slow");
			else
				$("#MeuDiv").show("slow");

			event.preventDefault();

		});
		 
	});
</script>
</head>
<body>
	<div id="MeuDiv"> Hello Word</div>
	<a id="esconder">Esconder</a>
	<a id="exibir">Mostrar</a>	
</body>
</html>