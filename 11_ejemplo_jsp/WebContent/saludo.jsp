<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%for(int nivel = 1; nivel <= 6; nivel++) { %>
		<h<%=nivel %>>Bienvenido a JSP</h<%=nivel %>>
		<%} %>
	</center>
</body>
</html>