<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/jquery.js"></script>
<script src="webstuff/js/bootstrap.js"></script>
	
<!-- Trigger the modal with a button -->
<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4 class="modal-title">Cadastro</h4>
	</div>
	<div class="modal-body">
		<!--Formulario de CADASTRO-->
		<form class="form-horizontal" id="efetuarCadastroUsuario">
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
					<button id="btnCadastrar" type="submit" class="btn btn-success">Cadastrar</button>
				</div>
			</div>
		</form>
		<!--FIM Formulario de CADASRTO-->
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	</div>
</div>

	
	<script>
	$("input").blur(function(){
	     if($(this).val() == ""){
	    	 $(this).css({"border-color" : "#F00", "padding": "2px"});
	     }else 
	    	 $(this).css({"border-color" : "#FFFFFF", "padding": "2px"});
	 })

	$("#efetuarCadastroUsuario").submit(function(event) {

		var nome = $("#inputNome").val();
		var email = $("#inputEmail").val();
		var senha = $("#inputPassword").val();
		
		var mensagem = '';
		var validacaoOk = true;
		
		if(nome == '' || email == '' || senha == '')
			jAlert('Favor, preencha o formul�rio completo.', 'Alert Dialog');
		else 
			return;
		
		breack;
	});	

	
	</script>