$(document).ready(function() {
			
		$("a").click(function(event) {
			var link = $(this);

			if (link.attr("id").match("esconder"))
				$("#MeuDiv").hide("slow");
			else
				$("#MeuDiv").show("slow");

			event.preventDefault();

		});
		
		$("visualizarEmpresa").live({
			click : function(){
				$.ajax({
					url : "retornoEmpresa",
					type : "POST",
					cache : false,
					data : {
						idtEmpresa : idtEmpresa
					},
					success : function (data){
						
					}
				})
			}
		})
		 
	});