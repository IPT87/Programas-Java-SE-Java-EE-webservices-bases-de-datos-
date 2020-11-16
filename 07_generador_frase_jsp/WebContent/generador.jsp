<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%for(int i = 0; i < 10; i++) {
		int n = (int)(Math.random() * 30 + 5); //aleatorio entre 5 y 35 %>
		<p style="font-size:<%=n%>px">
			Texto de prueba
		</p>
	<%} %>
</body>
</html>