<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,model.Curso"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cursos por alumno</title>
</head>
<body>
	<%
		List<Curso> cursos = (List<Curso>) request.getAttribute("cursosPorAlumno");
	%>
	
	<%if(cursos == null) { %>
		<center>
			<table border="5" bgcolor="lightblue" bordercolor="green">
			  <tr>
			    <th>Curso</th>
			  </tr>
			 </table>
		 </center>
	<%} else { %>
	<center>
		<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="10" cellspacing="5">
		  <tr>
		    <th>Curso</th>
		  </tr>
		  <%for(int i = 0; i < cursos.size(); i++) { %>
		  <tr>
		    <td><%=cursos.get(i).getNombre() %></td>
		  </tr>
		  <%} %>
		</table>
	</center>
	<%} %>
	<br/><br/>
	<a href="FrontController?option=toInicio">Volver</a>
</body>
</html>