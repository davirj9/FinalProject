$(function() {
			
	$("a").click(function(event) {
		var link = $(this);

		if (link.attr("id").match("esconder"))
			$("#MeuDiv").hide("slow");
		else
			$("#MeuDiv").show("slow");

		event.preventDefault();

	});
	$(".visualizarEmpresa").live("click", function(){
			var idtEmpresa = $(this).attr("name");
			$.ajax({
				url : "retornoEmpresa",
				type : "POST",
				cache : false,
				data : {
					idtEmpresa : idtEmpresa
				},
				success : function (data){
					$(".ui-dialog-title").text('Idt da empresa: '+ idtEmpresa);
					$("#dialog-dialog-retornoEmpresa").dialog("open");
				}
			})
	})
});
