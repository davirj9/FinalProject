<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/jquery.js"></script>
<script src="webstuff/js/bootstrap.js"></script>


<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
	data-target="#myModalLogin"
	style="position: relative; top: 5px; left: 3em;">Login</button>


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
				<form class="form-horizontal" id="efetuarLoginUsuario"
					action="<%=request.getContextPath()%>/efetuarLoginUsuario"
					method="POST">

					<div class="control-group">
						<label class="control-label" for="inputEmail">Login</label>
						<div class="controls">
							<input name="login" type="text" id="inputLogin"
								placeholder="Login">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">Senha</label>
						<div class="controls">
							<input name="senha" type="password" id="inputPassword"
								placeholder="Password">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">

							<button type="submit" class="btn btn-success">Entrar</button>
						</div>
					</div>
				</form>
				<!--Formulario de login-->

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>