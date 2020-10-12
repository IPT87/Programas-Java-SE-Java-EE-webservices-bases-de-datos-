
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	
	%>
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
		
		 <h1>Lista de libros del tema: ${requestScope.nombreTema}</h1>   
		 
				<table border="1">
				    <tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>		    	
				    	<c:forEach var="libro" items="${requestScope.libros}">
				    		<tr>
				    			<td>${libro.titulo}</td>
								<td>${libro.autor}</td>
								<td>${libro.precio}</td>
								<td><a href="Controller?identificadorTema=${param.identificadorTema}&option=doAgregarCarrito&isbn=${libro.isbn}">Comprar</a></td>
							</tr>		    	
				    	</c:forEach>
				</table>
				
				<br/><br/>
				<h1>Carrito </h1>
		<c:if test="${!empty sessionScope.carrito}">
			<table border="1">
			    <tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>		    	
			    	<c:forEach var="carro" items="${sessionScope.carrito}" varStatus="s">
			    		<tr>
			    			<td>${carro.titulo}</td>
							<td>${carro.autor}</td>
							<td>${carro.precio}</td>
							<td><a href="Controller?identificadorTema=${param.identificadorTema}&option=doEliminarCarrito&pos=${s.index}">Eliminar</a></td>
						</tr>		    	
			    	</c:forEach>
			</table>
		</c:if>
			
		<br/><br/>
	</center>
<a href="Controller?option=doTemas">Otro tema</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="Controller?option=doProcesarCompra">Procesar compra</a>
</body>
</html>