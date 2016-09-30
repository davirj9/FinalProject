$(function() {
	
	$("#DivResultadoEmpresa").hide();
			
	$("a").click(function(event) {
		var link = $(this);

		if (link.attr("id").match("esconderMapa"))
			$("#MeuDiv").hide("slow");
		if (link.attr("id").match("exibirMapa"))
			$("#MeuDiv").show("slow");
		if (link.attr("id").match("esconderEmpresas"))
			$("#divEmpresas").hide("slow");
		if (link.attr("id").match("exibirEmpresas"))
			$("#divEmpresas").show("slow");
		
		if (link.attr("id").match("esconderConsultaEmpresa"))
			$("#divConsultaEmpresas").hide("slow");
		if (link.attr("id").match("exibirConsultaEmpresa"))
			$("#divConsultaEmpresas").show("slow");
		
		event.preventDefault();

	});
	
	$(".visualizarEmpresa").live("click", function(){
			var idtEmpresa = $(this).attr("name");
			$.ajax({
				url : "retornoEmpresa",
				type : "POST",
				cache : false,
				dataType : 'json',
				data : {
					idtEmpresa : idtEmpresa
				},
				success : function (json){
					$("#DivResultadoEmpresa").show();
					$("#tableAjaxEmpresa").show();
					
					var dados = '<table id="tableAjaxEmpresa" class="table table-hover">';
					dados += 	'<thead>';
					dados +=		'<tr>';
					dados += 			'<th>'+json.nome+'</th>';
					dados += 			'<th>'+json.uf+'</th>';
					dados += 			'<th>'+json.bairro+'</th>';
					dados += 			'<th>'+json.descricao_logradouro+'</th>';
					dados += 			'<th>'+json.numero+'</th>';
					dados += 			'<th>'+json.cep+'</th>';
					dados += 			'<th>'+json.descricao+'</th>';
					dados +=   		 '</tr>';
					dados += 	'</thead>';
					dados += '</table>';
					
					$("#bodyTemplateAjaxDadosEmpresa").html(dados);	
				}
			})
	})
});
