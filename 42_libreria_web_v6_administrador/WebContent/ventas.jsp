<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="1">
				    <tr><tr><th>Titulo</th><th>Usuario</th><th>Fecha</th></tr>		    	
				    	<c:forEach var="venta" items="${requestScope.ventas}">
				    		<tr>
								<td>${venta.titulo}</td>
								<td>${venta.usuario}</td>
								<td>${venta.fecha}</td>
							</tr>
						</c:forEach>
				</table>
				<br><br>
				<a href="Controller?option=toSalir">Volver</a>
	</center>
</body>
</html>