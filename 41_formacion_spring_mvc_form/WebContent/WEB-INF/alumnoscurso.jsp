<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alumnos</title>
</head>
<body>
	<center>
		<h1>Alumnos</h1>
		<c:set var="alumnos" value="${requestScope.alumnoscurso }"/>
		<table border="1">
			<tr><th>Nombre</th><th>Usuario</th></tr>
			<c:forEach var="alumno" items="${alumnos}">
				<tr>
					<td>${alumno.nombre}</td><td>${alumno.usuario}</td>
				</tr>
			</c:forEach>
		</table>
		<br/><br/>
		<a href="menu">Volver</a>
	</center>
</body>
</html>