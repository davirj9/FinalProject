<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TESTE</title>

<script src="webstuff/js/jquery-1.10.1.min.js"></script>
<script src="webstuff/js/jquery.js"></script>
<script src="webstuff/js/bootstrap.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/webstuff/js/teste/teste.js"></script>

<link rel="stylesheet" href="webstuff/css/bootstrap.css">
<link rel="stylesheet" href="webstuff/css/bootstrap.min.css">
<link rel="stylesheet" href="webstuff/css/style.css">
<!-- Adicionando Javascript -->
</head>

<body>

	<label for="montadora">Montadora:</label>
	<select name="montadora" id="montadora">
		<option value="1">Fiat</option>
		<option value="2">Ford</option>
		<option value="3">Volkswagen</option>
	</select>
	<br />
	<label for="veiculo">Veículo:</label>
	<select name="veiculo" id="veiculo">
		<option value=""></option>
	</select>

	<select class="selectpicker">
		<optgroup label="Picnic">
			<option>Mustard</option>
			<option>Ketchup</option>
			<option>Relish</option>
		</optgroup>
		<optgroup label="Camping">
			<option>Tent</option>
			<option>Flashlight</option>
			<option>Toilet Paper</option>
		</optgroup>
	</select>
	
	<div class="bfh-selectbox" data-name="selectbox1">
  <div data-value="1">Option 1</div>
  <div data-value="2">Option 2</div>
  <div data-value="3">Option 3</div>
  <div data-value="4">Option 4</div>
  <div data-value="5">Option 5</div>
  <div data-value="6">Option 6</div>
  <div data-value="7">Option 7</div>
  <div data-value="8">Option 8</div>
  <div data-value="9">Option 9</div>
  <div data-value="10">Option 10</div>
  <div data-value="11">Option 11</div>
  <div data-value="12">Option 12</div>
  <div data-value="13">Option 13</div>
  <div data-value="14">Option 14</div>
  <div data-value="15">Option 15</div>
</div>

<div class="input input-group-sm">
<select class="selectpicker"  class="selectpicker" multiple
											data-container="body" data-selected-text-format="count>3"
											data-live-search="true">
  <option>Mustard</option>S
  <option>Ketchup</option>
  <option>Relish</option>
</select>
</div>


</body>

</html>