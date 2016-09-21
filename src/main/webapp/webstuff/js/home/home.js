$(function() {
	
	$("#DivResultadoEmpresa").hide();
			
	$("a").click(function(event) {
		var link = $(this);

		if (link.attr("id").match("esconderMapa"))
			$("#divMapa").hide("slow");
		if (link.attr("id").match("exibirMapa"))
			$("#divMapa").show("slow");
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
});
