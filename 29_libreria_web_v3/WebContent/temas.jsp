<%@page import="service.TemaServiceFactory"%>
<%@page import="service.TemaService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Temas</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%TemaService temaService = TemaServiceFactory.getTemaService();
	List<String> listaTemas = temaService.getTema(); %>
	
	<h3 style="text-align:right"><%=session.getAttribute("nombreUsuario") %></h3>
	
	<h2>Seleccione tema</h2>
	<form action="Controler?option=toListaTemas" method="post">
	<select name="temaElegido">
		<option value="todos">-todos-</option>
		<%for (int i = 0; i < listaTemas.size(); i++) {%>
			<option value=<%=listaTemas.get(i) %>><%=listaTemas.get(i) %></option>
		<%}%>
	</select>
	<br><br>
	<button type="submit" value="submit" class="btn btn-primary">Ver libros</button>
	</form>
	<br><br>
	<a href="Controler?option=toSalir">Volver</a>
</body>
</html>