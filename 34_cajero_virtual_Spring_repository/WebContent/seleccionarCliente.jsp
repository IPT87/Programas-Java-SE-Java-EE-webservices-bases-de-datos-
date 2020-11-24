<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FrontController?option=doVerCuentas" method="post" >	
		Seleccione cliente<br/>
		<select name="cliente">
			<c:set var="clientes" value="${requestScope.clientes }"/>

			<c:forEach var="cliente" items="${clientes }">
				<option value="${cliente.dni}">${cliente.nombre}</option>
			</c:forEach>
		</select>
		<br/><br/>
		<p align="center"><input type="submit" value="Siguente"></p>
	</form>
	<p align="right"><a href="FrontController?option=toInicio">Volver al menu</a></p>
</body>
</html>