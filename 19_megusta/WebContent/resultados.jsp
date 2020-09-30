<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%int contador = session.getAttribute("contador") != null ? (Integer) session.getAttribute("contador") : 0;
	int megusta =  application.getAttribute("megusta") != null ? (Integer) application.getAttribute("megusta") : 0;%>
	<h1>Total de visitas a mi pagina: <%=contador %></h1>
	<h1>Total megusta: <%=megusta %></h1>
	<br/><br/>
	<a href="inicio.html">Volver</a>
</body>
</html>