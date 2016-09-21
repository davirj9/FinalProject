$(function(){
	
	$("#tableAjaxEmpresa").hide();
	
$("#openBtn").click(function(){
	var idtEmpresa = 1;
		$.ajax({
			url : "retornoEmpresa",
			type : "POST",
			cache : false,
			dataType : 'json',
			data : {
				idtEmpresa : idtEmpresa
			},
			success : function (json){
				$("#tableAjaxEmpresa").show();
				
				var dados = '<table id="tableAjaxEmpresa" class="table table-hover">';
				dados += 	'<thead>';
				dados +=		'<tr>';
				dados += 			'<th>'+json.nomeEmpresa+'</th>';
				dados += 			'<th>'+json.data_inclusao+'</th>';
				dados += 			'<th>'+json.descricaoPerfil+'</th>';			
				dados +=   		 '</tr>';
				dados += 	'</thead>';
				dados += '</table>';
					
				$("#bodyTemplateAjaxDadosEmpresa").html(dados);	
			}
		})
})

$("#openBtn2").click(function(){
	$("#tableAjaxEmpresa").show();
})

})