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
		<h1>Alumnos</h1>
		<%List<Alumno> alumnos=(List<Alumno>)request.getAttribute("alumnoscurso"); %>
		<table border="1">
			<tr><th>Nombre</th><th>Usuario</th></tr>
			<%for(Alumno alumno:alumnos){ %>
				<tr>
					<td><%=alumno.getNombre() %></td><td><%=alumno.getUsuario() %></td>
				</tr>
			<%} %>
			
		</table>
		<br/><br/>
		<a href="FrontController?option=toMenu">Volver</a>
	</center>
</body>
</html>