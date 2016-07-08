<%@page import="javax.xml.ws.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="javax.swing.text.html.FormSubmitEvent"%>
<%@page import="java.awt.event.InputEvent"%>
<%@page import="java.io.ObjectInputStream.GetField"%>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="Pontos cardeais">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="webstuff/css/bootstrap.css">
<link rel="stylesheet" href="webstuff/css/bootstrap.min.css">
<link rel="stylesheet" href="webstuff/css/style.css">

<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/bootstrap.js"></script>

<title>Pontos Cardeais</title>
</head>

<body>

	<%--
           String sec = (String)session.getAttribute ("abre_secao");// aki estou recebendo a sessao antes converter num String e colocando numa variavel "sec"
           if(sec!=null){ // se a sessao for diferente de null (caso a variavel tiver algun dado)
                   
                   //out.println("Sessao aberta no sistema com o seguinte email "+sec);
           }else{
            String volta_index = "index.jsp";//coloca o index.jsp num variavel string
             response.setStatus(response.SC_MOVED_TEMPORARILY); // preparar o status da pagina para ser movida temporariamente
             response.setHeader("Location", volta_index); 	//se a variavel for null entao redireciona a pagiana para index.jsp
           
           }
           
        --%>


	<div class="container">
		<header id="header" class="">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
						<a class="brand">O Logo do projeto</a>
						<ul class="nav" style="position: relative; top: 0px;">
							<li class="divider-vertical"></li>
							<li class=""><a href="#">Home</a></li>
							<!--
                                -->
							<li class="divider-vertical"></li>
							<li><a href="#">Sobre Nós</a></li>
							<!--
                                -->
							<li class="divider-vertical"></li>
							<li><a href="#">Produtos</a></li>
							<!--
                                -->
							<li class="divider-vertical"></li>

							<!--Início o DropDown-->

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"><font><font>Suspensa </font></font><b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#"><font><font>AÃ§Ã£o</font></font></a></li>
									<li><a href="#"><font><font>Outra aÃ§Ã£o</font></font></a>
									</li>
									<li><a href="#"><font><font>Outra coisa
													aqui</font></font></a></li>
									<li class="divider"></li>
									<li class="nav-header"><font><font>CabeÃ§alho
												Nav</font></font></li>
									<li><a href="#"><font><font>LigaÃ§Ã£o
													Separado</font></font></a></li>
									<li><a href="#"><font><font>Mais um elo
													separado</font></font></a></li>
								</ul></li>

							<!--Início o Formulario-->
							<form class="navbar-form pull-right">
								<Input type="text" placeholder="Informe seu cep">
								<button type="submit" class="btn">
									<font><font>Pesquisar</font></font>
								</button>
							</form>
							<!--Termina o formulario-->

							<!--Termina o DropDown-->
						</ul>

						<!--Início cadastro-->
						<a href="#" class="btn btn-mini btn-primary" id="openBtn"
							style="position: relative; top: 5px; left: 2em; display: none;">Cadastrar</a>
						<!--Início Login-->
						<!-- Button to trigger modal -->
						<%
							// clicar no link é direcionado
							// para pagina endSession.jsp
						%>
						<a href="endSession.jsp" class=" btn btn-mini btn-danger"
							style="position: relative; top: 5px; left: 2em;">Fazer
							log-out <i class="icon-off"></i>
						</a>
						<!--onde termina div procura-->

					</div>
				</div>
				<!--onde termina o Div navegador-->
			</div>
			<!--onde termina o o Div Span que controla o Navegador-->
		</header>
		<!-- / fim do header -->

		<div style="clear: both; padding-top: 15px; background: #FFF;"></div>

		<!--Corpo do sistema-->
		<div class="hero-unit corpo"
			style="background-color: rgba(192, 152, 83, 0.61);">

			<div class="controles_jsp" id="nadainda">
				<%
					// nesse input com tipo=botao
					// e empresso o valor da secao
				%>
				<Input class="btn btn-info disabled" type="button" placeholder=""
					value="<%--out.println("sessão aberta como o usuario: "+sec);--%>"
					style="position: relative; margin: auto; left: -4em; top: -4em;">

			</div>

			<h1>SEJA BEM VINDO</h1>
			<p>INFORMAÇÕES</p>
			<p>

				<button type="button" id="BtM" name="BTN_ap"
					class="btn btn-primary btn-large" onclick="">Aprenda</button>
			</p>
		</div>
		<!--Corpo do sistema-->
	</div>
	
		<%@ include file="utils/footer.jsp"%>

	<script>
		$(document).ready(function() {
			$('.dropdown-toggle').dropdown();
		});
	</script>

</body>
</html>