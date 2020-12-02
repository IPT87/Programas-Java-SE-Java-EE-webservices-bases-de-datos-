<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,model.Alumno"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnosNota");
	%>
	
	<%if(alumnos == null) { %>
		<center>
			<table border="5" bgcolor="lightblue" bordercolor="green">
			  <tr>
			    <th>Nombre</th>
			    <th>Email</th>
			  </tr>
			 </table>
		 </center>
	<%} else { %>
	<center>
		<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="10" cellspacing="5">
		  <tr>
		    <th>Nombre</th>
		    <th>Email</th>
		  </tr>
		  <%for(int i = 0; i < alumnos.size(); i++) { %>
		  <tr>
		    <td><%=alumnos.get(i).getNombre() %></td>
		    <td><%=alumnos.get(i).getEmail() %></td>
		  </tr>
		  <%} %>
		</table>
	</center>
	<%} %>
	<br/><br/>
	<a href="FrontController?option=toInicio">Volver</a>
</body>
</html>