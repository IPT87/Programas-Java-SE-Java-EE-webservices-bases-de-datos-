<%@page import="model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Cliente cliente = (Cliente) request.getAttribute("ficha");%>
		<center>
			<h1>Bienvenido a mi servlet!</h1>
			<h2>Usuario: <%=cliente.getUser()%></h2>
			<h2>edad: <%=cliente.getEdad()%></h2>
			<h2>email: <%=cliente.getEmail()%></h2>
			</br>
			<a href='inicio.html'>Volver</a>
		</center>
</body>
</html>