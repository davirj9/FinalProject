var aposInicializado = function(){
	iniciaTextArea();
//	$("#gerar").click(testaGeraDocumento);
//	$("#btnMontar").click(testaMontagem);
	
};

var iniciaTextArea = function(){
	console.log("iniciando Text Area");
	CKEDITOR.replace( 'editor1' );
};

//var testaGeraDocumento = function(){
////	console.log(CKEDITOR.instances.editor1.getData());
//	console.log("html gerado: "+CKEDITOR.instances.editor1.document.getBody().getHtml());
//	console.log("Texto gerad: "+CKEDITOR.instances.editor1.document.getBody().getText());
//}

var testaMontagem = function(){
	console.log("testando montagem");
	
	var editor = CKEDITOR.instances.editor1;
	var texto = '<strong></strong><h1 style="text-align: center;"><strong></strong><span style="font-size:36px;"><em><strong>Titulo</strong></em></span></h1><p style="text-align:justify"><strong></strong><br></p><p style="text-align:justify"><strong>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel nibh non lacus viverra egestas sit amet a sapien. Nunc viverra a ante vel ultricies. Sed posuere lacus eget dictum elementum. Maecenas bibendum nisi vitae nibh laoreet, sed interdum diam convallis. Nullam metus nisi, laoreet sit amet condimentum eget, porta et est. Vivamus vitae convallis tellus. Aliquam aliquet nunc convallis arcu dictum, ullamcorper dictum mi sollicitudin. Integer ornare dui magna, in aliquet nibh cursus dapibus.</strong></p><p style="text-align:justify"><em>Maecenas facilisis, velit et gravida cursus, lectus tortor fringilla mauris, et luctus nisi ligula non tellus. Sed aliquet ac diam a rutrum. Duis posuere diam ut dui ultrices, et sodales elit porttitor. Pellentesque sed venenatis urna. Phasellus condimentum, massa et dignissim posuere, eros lorem consequat massa, eget iaculis felis nisl ut nisi. Ut a dignissim nibh. Donec molestie risus nec maximus venenatis.</em></p><p style="text-align:justify"><s>Duis eget ante sollicitudin, fringilla risus ut, maximus orci. Cras vulputate elit sed elementum elementum. Maecenas maximus ante eget posuere lacinia. Nunc lacinia venenatis nisl, sed fringilla arcu vulputate id. Nam eget scelerisque lectus. Morbi in neque risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam urna a ante varius vestibulum. Praesent malesuada finibus ipsum, at viverra enim tempor vel. Sed mollis congue nisi, eu pretium nulla interdum nec. Nam elementum ultricies arcu, eget blandit nibh laoreet et. Quisque consectetur purus id massa commodo, at facilisis diam vehicula. Maecenas nec sollicitudin sapien, non aliquet tortor.</s></p>correspondencia.js:1 Texto gerad: TituloLorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel nibh non lacus viverra egestas sit amet a sapien. Nunc viverra a ante vel ultricies. Sed posuere lacus eget dictum elementum. Maecenas bibendum nisi vitae nibh laoreet, sed interdum diam convallis. Nullam metus nisi, laoreet sit amet condimentum eget, porta et est. Vivamus vitae convallis tellus. Aliquam aliquet nunc convallis arcu dictum, ullamcorper dictum mi sollicitudin. Integer ornare dui magna, in aliquet nibh cursus dapibus.Maecenas facilisis, velit et gravida cursus, lectus tortor fringilla mauris, et luctus nisi ligula non tellus. Sed aliquet ac diam a rutrum. Duis posuere diam ut dui ultrices, et sodales elit porttitor. Pellentesque sed venenatis urna. Phasellus condimentum, massa et dignissim posuere, eros lorem consequat massa, eget iaculis felis nisl ut nisi. Ut a dignissim nibh. Donec molestie risus nec maximus venenatis.Duis eget ante sollicitudin, fringilla risus ut, maximus orci. Cras vulputate elit sed elementum elementum. Maecenas maximus ante eget posuere lacinia. Nunc lacinia venenatis nisl, sed fringilla arcu vulputate id. Nam eget scelerisque lectus. Morbi in neque risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam urna a ante varius vestibulum. Praesent malesuada finibus ipsum, at viverra enim tempor vel. Sed mollis congue nisi, eu pretium nulla interdum nec. Nam elementum ultricies arcu, eget blandit nibh laoreet et. Quisque consectetur purus id massa commodo, at facilisis diam vehicula. Maecenas nec sollicitudin sapien, non aliquet tortor.';
	console.log(texto);
	
	var textoJava = "<strong></strong><h1 style=\"text-align: center;\"><strong></strong><span style=\"font-size:36px;\"><em><strong>Titulo</strong></em></span></h1><p style=\"text-align:justify\"><strong></strong><br></p><p style=\"text-align:justify\"><strong>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel nibh non lacus viverra egestas sit amet a sapien. Nunc viverra a ante vel ultricies. Sed posuere lacus eget dictum elementum. Maecenas bibendum nisi vitae nibh laoreet, sed interdum diam convallis. Nullam metus nisi, laoreet sit amet condimentum eget, porta et est. Vivamus vitae convallis tellus. Aliquam aliquet nunc convallis arcu dictum, ullamcorper dictum mi sollicitudin. Integer ornare dui magna, in aliquet nibh cursus dapibus.</strong></p><p style=\"text-align:justify\">"
			+ "<em>Maecenas facilisis, velit et gravida cursus, lectus tortor fringilla mauris, et luctus nisi ligula non tellus. Sed aliquet ac diam a rutrum. Duis posuere diam ut dui "
			+ "ultrices, et sodales elit porttitor. Pellentesque sed venenatis urna. Phasellus condimentum, massa et dignissim posuere, eros lorem consequat "
			+ "massa, eget iaculis felis nisl ut nisi. Ut a dignissim nibh. Donec molestie risus nec maximus venenatis.</em></p><p style=\"text-align:justify\"><s>Duis eget ante sollicitudin, fringilla risus "
			+ "ut, maximus orci. Cras vulputate elit sed elementum elementum. Maecenas maximus ante eget posuere lacinia. Nunc lacinia venenatis nisl, "
			+ "sed fringilla arcu vulputate id. Nam eget scelerisque lectus. Morbi in neque risus. Vestibulum ante ipsum primis in faucibus orci "
			+ "luctus et ultrices posuere cubilia Curae; Sed aliquam urna a ante varius vestibulum. Praesent malesuada finibus ipsum, at viverra enim tempor "
			+ "vel. Sed mollis congue nisi, eu pretium nulla interdum nec. Nam elementum ultricies arcu, eget blandit nibh laoreet et. Quisque consectetur "
			+ "purus id massa commodo, at facilisis diam vehicula. Maecenas nec sollicitudin sapien, non aliquet tortor.</s></p>correspondencia.js:1 "
			+ "Texto gerad: TituloLorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel nibh non lacus viverra egestas sit amet "
			+ "a sapien. Nunc viverra a ante vel ultricies. Sed posuere lacus eget dictum elementum. Maecenas bibendum nisi vitae nibh laoreet, "
			+ "sed interdum diam convallis. Nullam metus nisi, laoreet sit amet condimentum eget, porta et est. Vivamus vitae convallis tellus. "
			+ "Aliquam aliquet nunc convallis arcu dictum, ullamcorper dictum mi sollicitudin. Integer ornare dui magna, in aliquet nibh "
			+ "cursus dapibus.Maecenas facilisis, velit et gravida cursus, lectus tortor fringilla mauris, et luctus nisi ligula non tellus"
			+ ". Sed aliquet ac diam a rutrum. Duis posuere diam ut dui ultrices, et sodales elit porttitor. Pellentesque sed venenatis "
			+ "urna. Phasellus condimentum, massa et dignissim posuere, eros lorem consequat massa, eget iaculis felis nisl ut nisi. "
			+ "Ut a dignissim nibh. Donec molestie risus nec maximus venenatis.Duis eget ante sollicitudin, fringilla risus ut, maximus "
			+ "orci. Cras vulputate elit sed elementum elementum. Maecenas maximus ante eget posuere lacinia. Nunc lacinia venenatis nisl, "
			+ "sed fringilla arcu vulputate id. Nam eget scelerisque lectus. Morbi in neque risus. Vestibulum ante ipsum primis in faucibus orci luctus et "
			+ "ultrices posuere cubilia Curae; Sed aliquam urna a ante varius vestibulum. Praesent malesuada finibus ipsum, at viverra enim tempor vel. Sed mollis congue "
			+ "nisi, eu pretium nulla interdum nec. Nam elementum ultricies arcu, eget blandit nibh laoreet et. Quisque consectetur purus id massa commodo, at facilisis "
			+ "diam vehicula. Maecenas nec sollicitudin sapien, non aliquet tortor.";
//	CKEDITOR.instances.editor1.setData(texto);
//	var p = new CKEDITOR.dom.element( 'editor1' );
	CKEDITOR.instances.editor1.document.getBody().setHtml(texto);
	console.log("inseriu");
	
//	var newElement = CKEDITOR.dom.element.createFromHtml(texto, editor.document);
//	editor.insertElement(newElement);
	
//	var fragment = oEditor.getSelection().getRanges()[0].extractContents();
//	var container = CKEDITOR.dom.element.createFromHtml(texto, oEditor.document);
//	fragment.appendTo(container)
//	oEditor.insertElement(container)
}

$(aposInicializado);