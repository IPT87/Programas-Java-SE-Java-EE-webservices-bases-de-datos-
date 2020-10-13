<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movimientos</title>
</head>
<body>
	<center>
		 <h1>Todos los movimientos</h1>   
				<table border="1">
				    <tr><th>Cuenta</th><th>Cantidad</th><th>Fecha</th><th>Operacion</th></tr>		    	
				    	<c:forEach var="movimiento" items="${requestScope.movimientos}">
				    		<tr>
				    			<td>${movimiento.idCuenta}</td>
								<td>${movimiento.cantidad}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" type="both" dateStyle = "short" timeStyle = "medium" value="${movimiento.fecha}" /></td>
								<td>${movimiento.operacion}</td>
							</tr>
						</c:forEach>
				</table>
	</center>
<button><a href="Controller?option=toMenu">Volver a menu</a></button>
</body>
</html>