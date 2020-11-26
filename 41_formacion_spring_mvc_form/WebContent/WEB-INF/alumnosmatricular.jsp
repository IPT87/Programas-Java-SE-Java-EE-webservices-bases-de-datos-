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
		<h1>Alumnos</h1>
		<form action="doSeleccionCursoMatricular" method="Post">
		<c:set var="alumnos" value="${requestScope.alumnos }"/>
		Alumno: <select name="usuario">
		
			<c:forEach var="alumno" items="${alumnos }">
				<option value="${alumno.usuario}">
					${alumno.nombre}
				</option>
			</c:forEach>
			</select>
		<br/>
		<input type="submit" value="Siguiente"/>	
		</form>
		<br/><br/>
		
	</center>
</body>
</html>