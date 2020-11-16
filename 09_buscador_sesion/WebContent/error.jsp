<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="comun.jsp" %>
	<h2>No hay entradas para el tema <%=request.getParameter("tema") %></h2>
	<a href="buscador.jsp">Volver</a>
</body>
</html>