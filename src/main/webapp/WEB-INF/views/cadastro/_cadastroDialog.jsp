<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/jquery.js"></script>
<script src="webstuff/js/bootstrap.js"></script>

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-mini btn-primary" data-toggle="modal" 
	data-target="#myModalCadastro"
	style="position: relative; top: 5px; right: -70em;">Cadastrar
<i class="icon-off"></i>
</button>
						
	<!-- Modal Cadastro -->
	<div id="myModalCadastro" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Cadastro</h4>
				</div>
				<div class="modal-body">
					<!--Formulario de CADASTRO-->
					<form class="form-horizontal" id="efetuarCadastroUsuario"
						action="<%=request.getContextPath()%>/efetuarCadastroUsuario"
						method="POST">
						<div class="control-group">
							<label class="control-label" for="inputNome">Nome</label>
							<div class="controls">
								<input name="nome" type="text" id="inputNome" placeholder="Nome">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputEmail">Email</label>
							<div class="controls">
								<input name="email" type="text" id="inputEmail"
									placeholder="Email">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputPassword">Senha</label>
							<div class="controls">
								<input name="password" type="password" id="inputPassword"
									placeholder="Password">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">

								<button type="submit" class="btn btn-success">Cadastrar</button>
							</div>
						</div>
					</form>
					<!--FIM Formulario de CADASRTO-->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>