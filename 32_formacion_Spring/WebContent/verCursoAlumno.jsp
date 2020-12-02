<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,model.Curso"%>
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
		List<Curso> cursos = (List<Curso>)request.getAttribute("cursosPorAlumno");
	%>
	
	<%if (cursos.size() == 0) { %>
		No hay resultados.
	<%} else { %>
			<table border="5" bgcolor="lightblue" bordercolor="green" cellspacing="3">
			<thead><tr>Curso</tr></thead>
				<%for (int i = 0; i < cursos.size(); i++) { %>
					<tr><td><%=cursos.get(i).getNombre() %></td></tr>
				<%} %>
			</table>
		<%} %>
</body>
</html>