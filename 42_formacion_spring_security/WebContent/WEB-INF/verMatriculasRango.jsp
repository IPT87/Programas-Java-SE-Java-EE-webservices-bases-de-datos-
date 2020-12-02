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
	<form action="doConsultarMatriculas" method="POST">
		Fecha inicio
		<input type="date" name="fechaInicio"/>
		&#160;&#160;Fecha fin
		<input type="date" name="fechaFin"/>
		<br/><br/>
		<input type="submit" value="Ver matriculas"/>
		<br/><br/>
	</form>

	<c:set var="matriculas" value="${requestScope.matriculasRango }"/>
	
	<c:if test="${! empty matriculas }">
		<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="5" cellspacing="5">
			<thead>
				<tr>
					<td>Alumno</td>
					<td>Curso</td>
					<td>Fecha</td>
				</tr>
			</thead>
			<c:forEach var="curso" items="${matriculas }">
				<c:set var="alumnos" value="${requestScope.alumnos }"/>
					<c:forEach var="alumno" items="${alumnos }">
						<tr>
							<td>${alumno.nombre}</td>
							<td>${curso.nombre}</td>
							<td>${curso.getFechaInicio}</td>
						</tr>
					</c:forEach>
			</c:forEach>
		</table>
	</c:if>
	<p align="right"><a href="menu">Volver</a></p>
</body>
</html>