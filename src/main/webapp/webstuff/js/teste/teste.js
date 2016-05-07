$(function() {

 $(document).ready(
	function() {
		$("#montadora").change(
				function() {
					console.log("foi");
					var options = "Logan";
					var key = "1";
					
						var teste = '<option value="' + key + '">' + options + '</option>';
					
					$("#veiculo").html(teste);
				});
			});
});

