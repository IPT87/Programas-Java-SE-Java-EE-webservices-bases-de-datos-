<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

</head>
<body>
<div class="container">
<%String usuario = (String) session.getAttribute("usuario");%>

<h4>Hola, <%=usuario %></h4>
<a href="Desconectar">Desconectar</a>

	<center>
	<h2>Buscar libros</h2>
	
		<form action="TipoBusqueda" method="post">
		<div class="input-group mb-3">
			<input type="radio" class="form-control" id="tematica" name="busqueda" value="porTematica" checked>
			<label class="radio-inline" for="tematica">Buscar por tematica</label><br>
			<input type="radio" class="form-control" id="isbn" name="busqueda" value="porIsbn">
			<label class="radio-inline" for="isbn">Buscar por isbn</label><br>
		</div>
			<input type="text" name="valor"/><br/>
			<button type="submit" class="btn btn-primary">Entrar</button>
		</form>
	</center>
	
</div>
</body>
</html>