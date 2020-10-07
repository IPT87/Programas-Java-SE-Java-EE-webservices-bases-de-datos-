<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Lo siento, se ha producido un error...</h1>
		<%-- <h1><%=exception.getMessage() %></h1> --%>
		<h1>${requestScope.mensajeError }</h1>
		<br/>
		<a href="Controller?option=toSalir">Volver</a>
	</center>
</body>
</html>