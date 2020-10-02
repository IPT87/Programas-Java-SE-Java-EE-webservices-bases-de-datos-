<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>seleccion</title>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >
</head>
<body>
	<center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.cliente.usuario}
            <h1>Seleccione Tema</h1>
            <br/>
		<form action="Controller?option=doLibros" method="post">
			<select name="tema">
				<option value="0">-Todos-</option>
				<c:forEach var="tema" items="${requestScope.temas}">
					<option value="${tema.idTema}">${tema.tema}</option>
				</c:forEach>
			</select>
			<br/><br/>
			<input type="submit" value="Libros"/>
		</form>	
	</center>
</body>
</html>