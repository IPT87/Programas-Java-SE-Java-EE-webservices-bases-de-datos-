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
	<center>
		<h1>Cursos</h1>
		<c:set var="cursos" value="${cursosalumno }"/>
		<table border="1">
			<tr><th>Curso</th><th>Duracion</th></tr>
			<c:forEach var="curso" items="${cursos }">
				<tr>
					<td>${curso.nombre}</td><td>${curso.duracion}</td>
				</tr>
			</c:forEach>
		</table>
		<br/><br/>
		<a href="menu">Volver</a>
	</center>
</body>
</html>