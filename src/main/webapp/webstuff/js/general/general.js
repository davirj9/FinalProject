/**
 * 
 * @param padrao - caso nao exista um argumento o padrao sera executado
 * @param argumento - argumneto que sera executado com a chamada
 * @returns
 */
function executaOpcional(padrao, argumento) {
	return (typeof argumento == 'undefined' ? padrao : argumento());
};

/**
 * metodo padrao que exibe conteudo de um panel por div Mostrar/Ocultar clicado
 * Tambe, alterna as divs Ocultar/Mostrar
 * @param div - div que foi clicada
 * @param comportamentoAdicional - comportamento a mais que por padrao eh null
 * */
function mostraEscondeDivs(div, comportamentoAdicional) {
	div.closest(".panel").find(".mostraEscondeConteudo").toggle("slow");
	div.toggle(1);
	div.siblings(".mostraEscondeDiv").toggle(1);
	executaOpcional(null, comportamentoAdicional);
};

/**
 * metodo padrao que exibe conteudo de um panel por checkBox clicado
 * Tambe, alterna as divs Ocultar/Mostrar
 * @param chechk check box que foi clicado
 * @param comportamentoAdicional - comportamento a mais que por padrao eh null
 * */
function checkEscondeDivs(check, comportamentoAdicional) {
	check.closest(".panel").find(".mostraEscondeConteudo").toggle("slow");
	check.siblings(".mostraEscondeDiv").toggle(1);
	executaOpcional(null, comportamentoAdicional);
};

/**
 * Dialog de alerta
 * @param titulo - Titulo que sera exibido
 * @param texto - texto que sera exibido 
 * @param confirm - metodo que sera executado caso seja confirmado pelo user.
 * @param cancel - metodo que sera executado caso seja cancelado pelo user - por padrao eh null.
 * */
function alertaConfirm(titulo, texto, confirm, params, cancel) {
	$('<div></div>').appendTo('body').html('<div><h6>'+texto+'</h6></div>')
			.dialog({
				modal : true,
				title : titulo,
				zIndex : 10000,
				autoOpen : true,
				width : 'auto',
				resizable : false,
				buttons : {
					Sim : function() {
						console.log("Teste OK");
						confirm(params);
						$(this).dialog("close");
					},
					Não : function() {
						console.log("TESTE NO");
						executaOpcional(null, cancel);
						$(this).dialog("close");
					}
				},
				close : function(event, ui) {
					$(this).remove();
				}
			});
	$(".ui-dialog-titlebar-close")
	.addClass(
			"ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close");
	$(".ui-dialog-titlebar-close")
	.append(
			'<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span class="ui-button-text">close</span>');
};


//function validaData(pData, mensagem){
//	data = $.trim(pData.get(0).value);
//	if(data == "" || (data != "" && data.length  != 10)){
//		mensagem += "O campo: "+pData.text()+" está invalido.<br/>";
//	}
//	return mensagem;	
//};

function validaData(pData, mensagem){
	data = pData.val();
	if(data == "" || (data != "" && data.length  != 10)){
		mensagem += "O campo: <b>"+getLabel(pData)+"</b> está inválido.<br/>";
	}
	return mensagem;	
};

function validaCampoNulo(pCampo, mensagem, pLabel){
	campo = $.trim(pCampo.get(0).value);
	if(campo == ""){
		mensagem += "O campo: <b>"+pLabel+"</b> não pode ser nulo.<br/>";
	}
	return mensagem;
};

/**
 * 
 * @param rowClass - class da row onde se encontram os checkBoxes
 * @param mensagem
 * @param pLabel
 */
function validaAoMenosUmCheckBox(rowClass, mensagem, pLabel){
	if(empty(rowClass.find("input[type=checkbox]:checked").length)){
		mensagem += "Ao menos 1 opção referente à: <b>"+pLabel+"</b> deve ser preenchido.<br/>";
	}
	return mensagem;
};

function validaRadioButton(name, mensagem, pLabel){
	if(!$("input[name='"+name+"']").is(':checked')){
		mensagem += "Ao menos 1 opção referente à: <b>"+pLabel+"</b> deve ser preenchida.<br/>";
	}
	return mensagem;
};

/**
 * 
 * @param inicio data de inicio
 * @param fim data fim
 * @param mensagem - retorna a mensagem com erro quando nao seja validado
 * @returns
 */
function compara(inicio, fim, mensagem) {
	if(!empty(inicio.val()) && !empty(fim.val())){
	    if (gerarData(inicio.val()) > gerarData(fim.val())){
	    	mensagem += "<b>"+getLabel(inicio) + "</b> não pode ser maior que <b>"+getLabel(fim)+"</b>. <br/>";
	    }
	}
    return mensagem;
};

/**
 * Metodo utilizado para comparar determinada data com a data de hoje. 
 * @param data - data que deseja compara com a data de hoje
 * @param mensagem - retorna a mensagem com erro quando nao seja validado
 */
function comparaHoje(data, mensagem){
	var hoje = new Date();
	hoje.setHours(0,0,0,0)
	if(!empty(data.val())){
		if(gerarData(data.val()) < hoje){
			mensagem += "<b>"+getLabel(data) + "</b> não pode ser menor que a data de hoje. <br/>";
		}
	}
	return mensagem;
};

function validaPeriodo(inicio, fim, periodo, mensagem){
	dtInicio = gerarData(inicio.val());
	dtFim = gerarData(fim.val());
	var dataLimite = dtInicio.setDate(dtInicio.getDate() + periodo);
	if(dtFim > dataLimite){
		mensagem += " O período entre: <b>"+getLabel(inicio)+"</b> e <b>"+getLabel(fim)+"</b> deve ser no máximo de 1 ano. <br/>";
	}
	return mensagem;
};

/**
 * Verifica se a variavel esta nula, vazia ou zerada
 * @param e variavel 
 * @returns {Boolean}
 */
function empty(e) {
    switch(e) {
        case "":
        case 0:
        case "0":
        case null:
        case false:
        case typeof this == "undefined":
            return true;
                default : return false;
    }
};

/**
 * 
 * @param mensagem - retorna um jAlert com a mensagem que foi enviada.
 * @returns {Boolean} - retorna verdadeiro se a mensagem estiver vazia.
 */
function isAlert(mensagem){
   if(!empty(mensagem)){
	   jAlert(mensagem, "Alerta");
	   return false;
   }
   return true;  
};

/**
 * Remove um elemento caso exista em determinado valor
 * Obs: slice - remove o elemento caso esteja no final, para que nao seja gerado array desnecessario
 * @param value - valor que sera verificado
 * @param elemento - elemento que sera removido
 * @returns - retorna o proprio valor caso nao possua elemento, ou um array caso possua o elemento
 */

function split(value, elemento){
	if(value.slice(-1) === elemento){
		value = value.substring(0, value.length - 1);
	}
	
	if(value.indexOf(elemento)  !== -1){
		value = value.split(elemento)
	}
	
	return value;
};

function replaceAll(find, replace, str) {
	return str.replace(new RegExp(find, 'g'), replace);
};

/**
 * limpa input text bloqueados de determinada linha
 */
function eraserText(){
	$(this).closest(".row").find(":input[type=text], :input[type=hidden]").val('');
//	id = $(this).attr("id");
//	$("#" + id).hide();
};

function gerarData(str) {
    var partes = str.split("/");
    return new Date(partes[2], partes[1] - 1, partes[0]);
};

function getLabel(element){
	return $("label[for='"+element.attr('id')+"']").text();
};



