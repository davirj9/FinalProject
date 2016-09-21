$("#efetuarCadastroUsuario").submit(function(event) {

	var nome = $("#InputNome").val();
	var email = $("#InputEmailFirst").val();
	var email2 = $("#InputEmailSecond").val();
	var senha = $("#InputSenha").val();
	
	if(email == email2)
		$.ajax({
			url : 'cadastroUsuario',
			type : "POST",
			cache : false,
			dataType : 'json',
			data : {nome : nome,
					email : email,
					senha : senha},
			success : function(data) {
			}		
			
		});
	else
		alert('A confirmação do email falhou, favor digitar novamente');
	
});	