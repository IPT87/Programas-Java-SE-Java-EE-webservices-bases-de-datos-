<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Cursos</h1>
		<%List<Curso> cursos=(List<Curso>)request.getAttribute("cursosalumno"); %>
		<table border="1">
			<tr><th>Curso</th><th>Duracion</th></tr>
			<%for(Curso curso:cursos){ %>
				<tr>
					<td><%=curso.getNombre() %></td><td><%=curso.getDuracion() %></td>
				</tr>
			<%} %>
			
		</table>
		<br/><br/>
		<a href="FrontController?option=toMenu">Volver</a>
	</center>
</body>
</html>