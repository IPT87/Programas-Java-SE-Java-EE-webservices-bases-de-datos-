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
	<table border='1'>
	<% int numero = Integer.parseInt(request.getParameter("numero")); %>
	<h3>Tabla de <%=numero%></h3>
		<%for (int fila = 1; fila <= 10; fila++) {%>
			<tr>
				<td><%=numero%> x <%=fila%></td>
				<td><%=(fila * numero)%></td>
			</tr>
		<%}%>
		</table>
	</center>
</body>
</html>