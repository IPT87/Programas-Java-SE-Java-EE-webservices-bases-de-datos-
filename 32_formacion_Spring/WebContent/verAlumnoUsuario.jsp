<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Alumno"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Alumno alumno = (Alumno)request.getAttribute("alumnoPorUsuario");
	%>
	
	<%if (alumno == null) { %>
		No hay resultados.
	<%} else { %>
			<h3><%=alumno.getNombre() %></h3>
		<%} %>
</body>
</html>