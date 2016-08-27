
function verificaPastaValida(pastaValue){
	var retorno =  true;
	if(empty(pastaValue)) retorno = false;
	$.each(pastaValue, function( index, value ){
		if (!value.replace(/[^0-9]+/g, "") != "") {
			retorno =  false;
		}
	});
	
	return retorno;
};

function buscaPastas(objeto, metodo){
	if(verificaPastaValida(objeto.pastaValue)){
		objeto.divPastaPesquisa.removeClass("form-group has-error").addClass("input input-group-sm");
			$.ajax({	
				url : $("#contextPath").val()+ metodo,
				type : "POST",
				cache : false,
				dataType : 'json',
				data : {pastaGeral : objeto.pastaValue}
				,
				success : function(data) {
					if(data.codigoGenerico == '0'){
						objeto.comSucessoPasta(data);
					} else {
						if(data.codigoGenerico == '1'){
							jError(data.mensagem, "Alerta");
						}
						objeto.semSucessoPasta(data);
					}
				},
				beforeSend : function(req) {
					$('#aguardando').show();
//					limpaFormulario(objeto.formPasta);
				},
				complete : function(req) {
					$('#aguardando').hide();
				},
				error: function (xhr, status, error) {
					$('#aguardando').hide();
					if(xhr.status != 401){
						jError(xhr.responseText, "Erro");
						$("#popup_ok").attr('name', 'refresh');
					}else
						window.location.href = $("#contextPath").val() + "carregarLogin";
			    }
			});
	} else {
		jAlert(
				"Dígite somente n&uacute;meros para pesquisar a pasta",	"Alerta");
		$("#divPastaPesquisa").removeClass("input input-group-sm").addClass("form-group has-error");
		objeto.semSucessoPasta();
//		limpaFormulario(objeto.formPasta);
	}
};

							


function novasPesquisas(objeto, adicional) {
	$('#filtroPrincipal').show('slow');	
	$('#btnPesquisar').show('slow');
	$('#btnLimpar').show('slow');
	$('#btnNovaPesquisa').hide();
	objeto.tabela.find("tbody").remove();
	objeto.tabela.find("thead").hide();
	objeto.paginacaoPesquisa.hide();
	objeto.naoExisteInfo.hide();
	executaOpcional(null, adicional);
};

function limpaFormulario(formulario, adicional){
	executaOpcional(null, adicional);
	formulario.find(':input').each(function() {
        switch(this.type) {
        	case 'hidden':
            case 'password':
            case 'select-multiple':
            case 'select-one':
            case 'text':
            case 'textarea':
                $(this).val('');
                break;
            case 'checkbox':
            case 'radio':
                this.checked = false;
        }
    });
};




