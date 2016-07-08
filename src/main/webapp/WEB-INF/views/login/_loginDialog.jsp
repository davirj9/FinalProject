<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/jquery.js"></script>
<script src="webstuff/js/bootstrap.js"></script>

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-mini btn-danger" data-toggle="modal" 
	data-target="#myModalLogin"
	style="position: relative; top: 5px; right: -57em;">Login
<i class="icon-off"></i>
</button>

	<!-- Modal Login-->
	<div id="myModalLogin" class="modal fade" role="dialog">
		<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Login</h4>
			</div>
			<div class="modal-body">
				<!--Formulario de login-->
				<form id="formLoginUser" method="post" action="<%=request.getContextPath()%>/efetuarLoginUsuario">
					<div class="input-group">
						<span class="input-group-addon"> <img alt="Usuário" src="<%=request.getContextPath()%>/webstuff/img/icones/usuario_20x20.png"> </span> <input type="text"
							class="form-control" placeholder="Usuário" name="emailUsuario" value="${loginUsuario}">
					</div>
					<div class="espacoTop"></div>
					<div class="input-group">
						<span class="input-group-addon"><img alt="Usuário" src="<%=request.getContextPath()%>/webstuff/img/icones/cadeado_20x20.png"></span> <input type="password"
							class="form-control" placeholder="Senha" name="senhaUsuario" maxlength="8">
					</div>
					<div class="espacoTop"></div>
					
					<h6>${msgErro}</h6>
					
					<input name="submit" value="Efetuar Login" type="submit" class="btn btn-primary submitButton"/>
					<a href="#" class="linkSenha">Esqueci minha senha</a>
			   </form>
				<!--Formulario de login-->

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>