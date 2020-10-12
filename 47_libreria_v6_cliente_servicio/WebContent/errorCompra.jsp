<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 
	<h1><%=exception.getMessage()%></h1>
--%>
	<h1>${requestScope.errores["SinLibrosException"]}</h1>
	<br/><br/>	
	<a href="Controller?option=toSalir">Salir</a>
</body>
</html>