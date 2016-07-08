$(function() {

$("#btnPesquisarEmpresas").click(function() {
		$.ajax({
			url : $("#contextPath").val() + 'pesquisarEmpresas',
			type : "POST",
			data : $("#formConsultaEmpresa").serialize(),
			success : function(data) {
				$('#tabelaEmpresasAjax').html(data);
				$('.infoTooltip').removeData('tooltip'); 
				$(".infoTooltip").tooltip({
					 hide: {
						 effect: "explode",
						 delay: 250
					 }
				});
			},
		});
	});
});