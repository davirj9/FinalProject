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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 
 
    <script type="text/javascript">
 
      $(document).ready( function() {
        $('#ocultarDiv').click(function () {
          $('.divTeste').addClass('hide');
        });
        $('#mostrarDiv').click(function () {
          $('.divTeste').removeClass('hide');
        });
      });
    </script>
  </head>
 
  <body>
  
    <div class="container">
 
      <div class="starter-template">
          <h1>Pagina 1</h1>
          <p class="lead">Essa é a página 1</p>
		  <button class="btn btn-default" type="submit" id="ocultarDiv">Ocultar</button>
          <button class="btn btn-default" type="submit" id="mostrarDiv">Mostrar</button>	 		
          <div class="divTeste">
	          <div class="panel panel-default">
					<div class="panel-body">
						<div class="mostraEscondeConteudo">
							TUDO VAI DAR CERTO
						</div>
					</div>
			  </div>
          </div>
      </div>
 
    </div><!-- /.container -->


<!-- Trigger the modal with a button -->
<input type="image" data-toggle="modal" 
	data-target="#myModalVisualizar"
	src="webstuff/img/icones/eye.png"
	style="position: relative; top: 5px; right: -57em;">
</input>
<input type="image" value="Enviar" id="btnVisualizarEmpresa" src="webstuff/img/icones/eye.png"></input>

	<!-- Modal Login-->
	<div id="myModalVisualizar" class="modal fade" role="dialog">
		<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Teste</h4>
			</div>
			<div class="modal-body">
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>
 
  </body>
</html>