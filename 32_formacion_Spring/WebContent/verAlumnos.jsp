<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,model.Alumno"%>
<!DOCTYPE html>
<html>
<head>
<style>
td {
  padding: 5px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Alumno> alumnos = (List<Alumno>)request.getAttribute("alumnos");
	%>
	
	<%if (alumnos == null) { %>
		No hay resultados.
	<%} else { %>
			<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="5" cellspacing="5">
			<thead><tr>Alumnos</tr></thead>
				<%for (int i = 0; i < alumnos.size(); i++) { %>
					<tr><td><%=alumnos.get(i).getNombre() %></td></tr>
				<%} %>
			</table>
		<%} %>
</body>
</html>