<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%int contador = (Integer) session.getAttribute("contador");%>
	<h1>Total de visitas a mi pagina: <%=contador %></h1>
	<br/><br/>
	<a href="inicio.html">Volver</a>
</body>
</html>