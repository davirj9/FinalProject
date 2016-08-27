$(function() {
	var versaoId = $("#versaoId") == null? (new Date()).getMilliseconds(): $("#versaoId").val();
	$(".dtPicker").datepicker({
		format : "dd/mm/yyyy",
		orientation: "top left",
		autoclose : true,
		todayHighlight : true
	});
	
	$(".dtPickerTime").datetimepicker({
		language: 'pt-BR',
        format: "dd/mm/yyyy hh:ii",
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
	});
	
	
	$('.selectpicker').selectpicker({
		'selectedText' : 'cat'
	});
	
	$(".pessoaPesquisa")
	.click(
		function() {
			sufixoPessoa = $(this).attr("name");
			$("#dialog-pessoa").data('name',
					$(this).attr("name")).dialog("open");
			$("#tablePessoa thead").hide();
			$("#tablePessoa tbody").remove();
			$("#htmlPaginacaoPessoa").empty();
			$("#textoPesquisaPessoa").val('');

			$(".ui-dialog-titlebar-close")
					.addClass(
							"ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close");
			$(".ui-dialog-titlebar-close")
					.append(
							'<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span class="ui-button-text">close</span>');
		});
	
	$(".correspondenteTitular")
		.click(
			function() {
				sufixoCorrespondenteTitular = $(this).attr("name");
				$("#dialog-correspondenteTitular").data('name',
						$(this).attr("name")).dialog("open");
				$("#tableCorrespondenteTitular thead").hide();
				$("#tableCorrespondenteTitular tbody").remove();
				$("#htmlPaginacaoCorrespondenteTitular").empty();
				$("#textoPesquisaCorrespondenteTitular").val('');

				$(".ui-dialog-titlebar-close")
						.addClass(
								"ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close");
				$(".ui-dialog-titlebar-close")
						.append(
								'<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span class="ui-button-text">close</span>');
			});
	
	$(".corresp")
		.click(
			function() {
				sufixoCorrespondente = $(this).attr("name");
				$("#dialog-correspondente").data('name', $(this).attr("name")).data('tipo', $(this).attr("title")).dialog("open");
				$("#tableCorrespondente thead").hide();
				$("#tableCorrespondente tbody").remove();
				$("#htmlPaginacao").empty();
				$("#textoPesquisaCorrespondente").val('');

				$(".ui-dialog-titlebar-close")
						.addClass(
								"ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close");
				$(".ui-dialog-titlebar-close")
						.append(
								'<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span class="ui-button-text">close</span>');
			});

	$(".titular")
		.click(
			function() {
			sufixoTitular = $(this).attr("name");
			$("#dialog-titular").data('name',
					$(this).attr("name")).dialog("open");
			$("#tableTitular thead").hide();
			$("#tableTitular tbody").remove();
			$("#htmlPaginacaoTitular").empty();
			$("#textoPesquisaTitular").val('');
	
			$(".ui-dialog-titlebar-close")
					.addClass(
							"ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close");
			$(".ui-dialog-titlebar-close")
					.append(
							'<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span class="ui-button-text">close</span>');
		});
	
	$(".titularInpi")
	.click(
		function() {
		sufixoTitularInpi = $(this).attr("name");
		$("#dialog-titularInpi").data('name',
				$(this).attr("name")).dialog("open");
		$("#tableTitularInpi thead").hide();
		$("#tableTitularInpi tbody").remove();
		$("#htmlPaginacaoTitularInpi").empty();
		$("#textoPesquisaTitularInpi").val('');

		$(".ui-dialog-titlebar-close")
				.addClass(
						"ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close");
		$(".ui-dialog-titlebar-close")
				.append(
						'<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span class="ui-button-text">close</span>');
	});
	
	$(".eraser").click(function() {
		name = $(this).attr("name");
		$("#correspTitular" + name).val('');
		id = $(this).attr("id");
		$("#" + id).hide();
	});
	
	$("#btnLimpar").click(function() {
		$("#form" + $(this).attr('title')).find(':input').each(function() {
	        switch(this.type) {
	            case 'password':
	            case 'select-multiple':
	            case 'select-one':
	            case 'text':
	            case 'hidden':
	            case 'textarea':
	                $(this).val('');
	                break;
	            case 'checkbox':
	            case 'radio':
	                this.checked = false;
	        }
	    });
	});
	
	$(".btnLimpar").click(function() {
		$("#form" + $(this).attr('name')).find(':input').each(function() {
	        switch(this.type) {
	            case 'password':
	            case 'select-multiple':
	            case 'select-one':
	            case 'text':
	            case 'hidden':
	            case 'textarea':
	                $(this).val('');
	                break;
	            case 'checkbox':
	            case 'radio':
	                this.checked = false;
	        }
	    });
	});
	
	$(".mostraEscondeDiv").click(function() {
		var id = "div" + $(this).attr('id');
		if ($('#' + id).css('display') == 'none') {
			$('#' + id).show("fast");
			$('#' + $(this).attr('id')).html('Ocultar');
		} else {
			$('#' + id).hide("fast");
			$('#' + $(this).attr('id')).html('Mostrar');
		}
		return false;
	});
	
	$(".infoTooltip").tooltip({
		 hide: {
			 effect: "explode",
			 delay: 250
		 }
	});
	
	$("#selecionaTodos").live("click", function() {
		$('.checkAll').attr('checked', this.checked);
	});

	$(".checkAll").live("click", function() {
		if ($(".checkAll").length == $(".checkAll:checked").length) {
			$("#selecionaTodos").attr("checked",
					"checked");
		} else {
			$("#selecionaTodos").removeAttr("checked");
		}
	});
	
});

function paginar(numPagina, url, tipo) {
	$.ajax({
		url : $("#contextPath").val() + url,
		type : "POST",
		cache : false,
		dataType : 'json',
		data:  $("#form" + tipo).serialize() + '&' + $.param({numPagina:numPagina}),
		success : function(json) {
			$("#tableAjax" + tipo + " tbody").remove();
			
			if(json.resultado.length > 0){
				$("#tableAjax" + tipo + " thead").show();
				$("#bodyTemplateAjax" + tipo).tmpl(json.resultado).appendTo("#tableAjax" + tipo);
				
				html = converteHtmlPaginacaoDinamico(json.paginacao.paginaMinima, json.paginacao.paginaMaxima, json.paginacao.paginaAtual, json.paginacao.totalPagina, json.paginacao.de, json.paginacao.ate, json.paginacao.total, url, tipo);
				
				html += '<div class="espacoRodape"></div>';
				
				$("#htmlPaginacaoAjax" + tipo).html(html);
				$("#htmlPaginacaoAjax" + tipo).show();
				$("#tableAjax" + tipo + " thead").show();
				
				$("#naoExisteInfo" + tipo).hide();
			}else{
				$("#naoExisteInfoAjax" + tipo).show();
				$("#htmlPaginacaoAjax" + tipo).empty();
			}
		},
		beforeSend : function(req) {
			$('#aguardando').show();
		},
		complete : function(req) {
			$('#aguardando').hide();
		},
		error : function(req) {
			$('#aguardando').hide();
			jError("Ocorreu um erro ao tentar efetuar a operação","Erro");
		},
		statusCode : {
			404 : function() {
				$('#aguardando').hide();
				jError("Ocorreu um erro ao tentar efetuar a operação","Erro");
			}
		}
	});			
}

function paginarSemJson(numPagina, url, tipo) {
	$.ajax({
		url : $("#contextPath").val() + url,
		type : "POST",
		cache : false,
		data:  $("#form" + tipo).serialize() + '&' + $.param({numPagina:numPagina}),
		success : function(data) {
			$("#tabela" + tipo).remove();
			$("#tabela" + tipo + "Ajax").html(data);
			$('.infoTooltip').removeData('tooltip'); 
			$(".infoTooltip").tooltip({
				 hide: {
					 effect: "explode",
					 delay: 250
				 }
			});
		},
		beforeSend : function(req) {
			$('#aguardando').show();
		},
		complete : function(req) {
			$('#aguardando').hide();
		},
		error : function(req) {
			$('#aguardando').hide();
			jError("Ocorreu um erro ao tentar efetuar a operação","Erro");
		},
		statusCode : {
			404 : function() {
				$('#aguardando').hide();
				jError("Ocorreu um erro ao tentar efetuar a operação","Erro");
			}
		}
	});			
}

function converteHtmlPaginacaoDinamico(min, max, actual, total, de, ate, totalRegistro, url, tipo){
	var html = '';

	html += 'Mostrando de ' + de + ' até ' + ate + ' de um total de ' + totalRegistro + '<br/>';	
	
	html += 
		'<div class="pagincacao" align="center">' +
		'<ul class="pagination">';
	
	for( var i = min; i <= max; i++ ){
		if( i == min ){
			if( actual == 1 ){
				html += 
					'<li class="disabled"><a href="#">&laquo;</a></li>';
			}else{
				html += 
					'<li><a href="#" onClick="paginar(' + '\''+ (actual - 1) + '\'' + ', ' + '\'' + url + '\'' + ',' + '\'' + tipo + '\'' + ');return false;">&laquo;</a></li>';
			}
		}
	
		if( actual == i ){
			html +=
				'<li class="active"><a href="#">' + i + ' <span class="sr-only"></span></a></li>';
		}else{
			html +=
				'<li><a href="#" onClick="paginar(' + '\'' + i + '\'' + ', ' + '\'' + url + '\'' + ',' + '\'' + tipo + '\'' + ');return false;">' + i + ' <span class="sr-only"></span></a></li>';
		}
		
		if( i == max ){
			if( actual == total ){
				html += 
					'<li class="disabled"><a href="#">&raquo;</a></li>';
			}else{
				html += 
					'<li><a href="#" onClick="paginar(' + '\'' + (actual + 1) + '\'' + ', ' + '\'' + url + '\'' + ',' + '\'' + tipo + '\'' + ');return false;">&raquo;</a></li>';
			}
			
		}		
	}
	
	html += '</ul></div>';
	
	return html;
}

function paginaPesquisa(objeto, numPagina) {
	$.ajax({
		url : $("#contextPath").val() + objeto.metodo,
		type : "POST",
		cache : false,
		dataType : 'json',
		data:  objeto.form.serialize() + '&' + $.param({numPagina: executaOpcional(null, numPagina)}),
		success : function(json) {
			objeto.tabela.find("tbody").remove();
			
			if(json.resultado.length > 0){
				objeto.tabela.find("thead").show();
				objeto.tabela.show();
				objeto.bodyTemplate.tmpl(json.resultado).appendTo(objeto.tabela);
				
				html = converteHtmlPaginacaoDinamico(
						json.paginacao.paginaMinima,
						json.paginacao.paginaMaxima,
						json.paginacao.paginaAtual,
						json.paginacao.totalPagina,
						json.paginacao.de,
						json.paginacao.ate,
						json.paginacao.total,
						objeto.metodo,
						objeto.nome);
				
				html += '<div class="espacoRodape"></div>';
				
				objeto.paginacaoPesquisa.html(html);
				objeto.paginacaoPesquisa.show();
				objeto.tabela.find("thead").show();
				
				objeto.naoExisteInfo.hide();
			}else{
				objeto.naoExisteInfo.show();
				objeto.paginacaoPesquisa.empty();
			}
		},
		beforeSend : function(req) {
			$('#aguardando').show();
			$('#filtro').hide('slow');
			$('#btnNovaPesquisa').show();
		},
		complete : function(req) {
			$('#btnPesquisar').hide();
			$('#btnLimpar').hide();
			$('#aguardando').hide();
		},
		error: function (xhr, status, error) {
			$('#aguardando').hide();
			if(xhr.status != 401){
				jError(xhr.responseText, "Erro");
				$("#popup_ok").attr('name', 'refresh');
			}else
				window.location.href = $("#contextPath").val() + "carregarLogin"+ "?v=" + versaoId;
	    },
		statusCode : {
			404 : function() {
				$('#aguardando').hide();
				jError("Ocorreu um erro ao tentar efetuar a operação","Erro");
				$("#popup_ok").attr('name', 'refresh');
			}
		}
	});			
};



function verificaNumero(e) {
    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        return false;
    }
}