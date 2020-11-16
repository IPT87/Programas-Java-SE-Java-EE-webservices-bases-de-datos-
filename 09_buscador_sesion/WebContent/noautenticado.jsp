<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>El usuario <%=request.getParameter("usuario") %> no esta autenticado</h2>
	<a href="login.html">Volver</a>
</body>
</html>