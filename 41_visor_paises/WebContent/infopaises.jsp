<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>

h1   {color: background;
  text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px darkblue; font-family: Courier New}
body {
  background-color: silver;
}
</style>
<meta charset="ISO-8859-1">
<title>Info paises</title>
</head>
<div class="container">
<body>

	<center>
		<h1>Paises:</h1>
		<form action="Controller?option=doPaisInfo" method="post">
			<select name="pais">
				<c:forEach var="pais" items="${requestScope.nombresPaises}">
					<option value="${pais}">${pais}</option>
				</c:forEach>
			</select>
			<br/><br/>
			<input type="submit" value="Ver Datos" />
		</form>
		<br>
		
		<div class="container">
		<table class="table table-dark table-bordered">
				    <tr><th>Nombre</th><th>Capital</th><th>Region</th><th>Numero habitantes</th></tr>
				    		<tr>
				    			<td>${requestScope.datosPais.nombre}</td>
								<td>${requestScope.datosPais.capital}</td>
								<td>${requestScope.datosPais.region}</td>
								<td>${requestScope.datosPais.habitantes}</td>
							</tr>
				</table>
				</div>
		<br>
		<div class="container">
			<img src="${requestScope.datosPais.bandera}" style="width:50%">
		</div>
	</center>
<div>
</body>
</html>