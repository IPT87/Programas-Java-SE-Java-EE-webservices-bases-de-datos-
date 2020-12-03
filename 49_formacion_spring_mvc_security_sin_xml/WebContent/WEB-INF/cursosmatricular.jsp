<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/stylesheet.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Cursos</h1>
		<form action="doMatricular" method="Post">
		<c:set var="cursos" value="${requestScope.cursosmatricular }"/>
		Curso: <select name="idCurso">
			
			<c:forEach var="curso" items="${cursos }">
				<option value="${curso.idCurso}">
					${curso.nombre}
				</option>
			</c:forEach>
			</select>
		<br/>
		<input type="submit" value="Matricular"/>	
		</form>
		<br/><br/>
		
	</center>
</body>
</html>