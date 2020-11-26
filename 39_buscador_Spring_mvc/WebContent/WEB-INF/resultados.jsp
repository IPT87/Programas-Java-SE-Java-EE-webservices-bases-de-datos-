<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b>${sessionScope.usuario}</b>
	<center>
		<c:forEach var="item" items="${requestScope.items }">
			<h2><a href="${item.url }">${item.titulo }</a></h2> <br/>
		</c:forEach>
	</center>
	
	<a href="toBuscador">Volver</a>
</body>
</html>