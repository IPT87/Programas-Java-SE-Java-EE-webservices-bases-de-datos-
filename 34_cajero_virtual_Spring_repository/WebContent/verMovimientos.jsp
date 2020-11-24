<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver movimientos</title>
</head>
<body>
	<c:set var="movimientos" value="${requestScope.movimientos }"/>
	
	<h2>Movimientos</h2>
	
	<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="5" cellspacing="5">
		<thead>
			<tr>
				<td>Cantidad</td>
				<td>Fecha</td>
				<td>Operacion</td>
			</tr>
		</thead>
		<c:forEach var="movimiento" items="${movimientos }">
			<tr>
				<td>${movimiento.cantidad}</td>
				<td>${movimiento.fecha}</td>
				<td>${movimiento.operacion}</td>
			</tr>
		</c:forEach>
	</table>
	<h3 align="right">Saldo: ${requestScope.saldo}&euro;</h3>
</body>
</html>