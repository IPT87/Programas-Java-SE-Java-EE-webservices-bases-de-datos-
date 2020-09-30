<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String usuario = (String) session.getAttribute("usuario");%>

	<h4>Hola, <%=usuario %></h4>

	<center>
		<h1>El elemento no existe</h1>
		<a href="eleccion.jsp">Volver</a>
	</center>
</body>
</html>