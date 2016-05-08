$(function() {
	$(document).ready(function() {

        function limpa_formulário_cep() {
            // Limpa valores do formulário de cep.
            $("#rua").val("");
            $("#bairro").val("");
            $("#cidade").val("");
            $("#uf").val("");
            $("#ibge").val("");
        }
        
        //Quando o campo cep perde o foco.
        $("#cep").blur(function() {

            //Nova variável "cep" somente com dígitos.
            var cep = $(this).val().replace(/\D/g, '');

            //Verifica se campo cep possui valor informado.
            if (cep != "") {

                //Expressão regular para validar o CEP.
                var validacep = /^[0-9]{8}$/;

                //Valida o formato do CEP.
                if(validacep.test(cep)) {

                    //Preenche os campos com "..." enquanto consulta webservice.
                    $("#rua").val("...")
                    $("#bairro").val("...")
                    $("#cidade").val("...")
                    $("#uf").val("...")
                    $("#ibge").val("...")

                    //Consulta o webservice viacep.com.br/
                    $.getJSON("//viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                        if (!("erro" in dados)) {
                            //Atualiza os campos com os valores da consulta.
                            $("#rua").val(dados.logradouro);
                            $("#bairro").val(dados.bairro);
                            $("#cidade").val(dados.localidade);
                            $("#uf").val(dados.uf);
                            $("#ibge").val(dados.ibge);
                            
                            $("#rua").prop('disabled', 'disabled');
                            $("#bairro").prop('disabled', 'disabled');
                            $("#cidade").prop('disabled', 'disabled');
                            $("#uf").prop('disabled', 'disabled');
                            
                        } //end if.
                        else {
                            //CEP pesquisado não foi encontrado.
                            limpa_formulário_cep();
                            alert("CEP não encontrado.");
                        }
                    });
                } //end if.
                else {
                    //cep é inválido.
                    limpa_formulário_cep();
                    alert("Formato de CEP inválido.");
                }
            } //end if.
            else {
                //cep sem valor, limpa formulário.
                limpa_formulário_cep();
            }
        });
    });

	$(document).ready(function() {
		$("#montadora").change(function() {
			console.log("foi");
			var options = "Logan";
			var key = "1";

			var teste = '<option value="' + key + '">' + options + '</option>';
			
			$("#veiculo").html(teste);
		});
	});

	$('input:radio[name="mesmoEndereco"]').click(function() {
						/*
						 * Só vamos fazer algo se o valor do campo for sim, é
						 * claro!
						 */

						if ($(this).val() == 'sim') {

							/*
							 * Precisamos antes alertar o tonhonhom que ele
							 * precisa selecionar uma cidade antes
							 */

							if ($('#cidadeResidencia option:selected').val() == 0) {

								alert('Você precisa primeiro selecionar o campo CIDADE amigo!');

							} else {

								/*
								 * Pega o valor do campo residencial e busca
								 * pelo elemento com este valor no
								 * correspondente para entrega
								 */

								var cidadeResidencia = $('#cidadeResidencia')
										.val();

				$('#cidadeEntrega option[value="'+ cidadeResidencia + '"]').attr({selected : "selected"
					});

							}

						}

					}

			);

});
