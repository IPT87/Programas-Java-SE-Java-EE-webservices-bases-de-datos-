<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<center>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.cliente.usuario}
		<br/><br/>
		
		 <h1>Lista de libros del tema: ${requestScope.tema}</h1>   
				<table border="1">
				    <tr><tr><th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
				    	<c:forEach var="libro" items="${requestScope.libros}">
				    		<tr>
				    			<td><a href="Controller?option=doAgregar&titulo=${libro.titulo}&autor=${libro.autor}&precio=${libro.precio}">agregar</a></td>
								<td>${libro.titulo}</td>
								<td>${libro.autor}</td>
								<td>${libro.precio}</td>
							</tr>
						</c:forEach>
				</table>
				<br/><br/>	
		<br/><br/>
		
		<h1>Carrito</h1>   
				<table border="1">
				    <tr><tr><th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
				    	<c:forEach var="libro" items="${sessionScope.librosCarrito}" varStatus="status">
				    		<tr>
				    			<td><a href="Controller?option=doEliminar&index=${status.index}">quitar</a></td>
								<td>${libro.titulo}</td>
								<td>${libro.autor}</td>
								<td>${libro.precio}</td>
							</tr>
						</c:forEach>
				</table>
				<br/><br/>	
		<br/><br/>
	</center>
<a href="Controller?option=doTemas">Otro tema</a>
</body>
</html>