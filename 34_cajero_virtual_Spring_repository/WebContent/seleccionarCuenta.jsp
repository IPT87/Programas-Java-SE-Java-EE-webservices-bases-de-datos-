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
	<form action="FrontController?option=doAsignarCuenta" method="post" >	
		Seleccione cuenta<br/>
		<select name="cuenta">
			<c:set var="cuentas" value="${requestScope.cuentas }"/>
			<c:forEach var="cuenta" items="${cuentas }">
				<option value="${cuenta.numeroCuenta}">${cuenta.numeroCuenta}</option>
			</c:forEach>
		</select>
		<br/><br/>
		<p align="center"><input type="submit" value="Asignar"></p>
	</form>
	<p align="right"><a href="FrontController?option=toInicio">Volver al menu</a></p>
</body>
</html>