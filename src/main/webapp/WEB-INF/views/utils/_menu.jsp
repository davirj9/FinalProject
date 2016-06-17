<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<meta charset="utf-8">
<meta name="description" content="Pontos cardeais">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="webstuff/css/bootstrap.css">
<link rel="stylesheet" href="webstuff/css/bootstrap.min.css">
<link rel="stylesheet" href="webstuff/css/style.css">

<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/bootstrap.js"></script>


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
							<li><a href="#">Sobre NÛs</a></li>
							<!--
                                -->
							<li class="divider-vertical"></li>
							<li><a href="#">Produtos</a></li>
							<!--
                                -->
							<li class="divider-vertical"></li>

							<!--InÌcio o DropDown-->

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"><font><font>Suspensa </font></font><b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#"><font><font>A√ß√£o</font></font></a></li>
									<li><a href="#"><font><font>Outra a√ß√£o</font></font></a>
									</li>
									<li><a href="#"><font><font>Outra coisa
													aqui</font></font></a></li>
									<li class="divider"></li>
									<li class="nav-header"><font><font>Cabe√ßalho
												Nav</font></font></li>
									<li><a href="#"><font><font>Liga√ß√£o
													Separado</font></font></a></li>
									<li><a href="#"><font><font>Mais um elo
													separado</font></font></a></li>
								</ul></li>

							<!--InÌcio o Formulario-->
							<form class="navbar-form pull-right">
								<Input type="text" placeholder="Informe seu cep">
								<button type="submit" class="btn">
									<font><font>Pesquisar</font></font>
								</button>
							</form>
							<!--Termina o formulario-->

							<!--Termina o DropDown-->
						</ul>

						<!--InÌcio cadastro-->
						<a href="#" class="btn btn-mini btn-primary" id="openBtn"
							style="position: relative; top: 5px; left: 2em; display: none;">Cadastrar</a>
						<!--InÌcio Login-->
						<!-- Button to trigger modal -->
						<%
							// clicar no link È direcionado
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