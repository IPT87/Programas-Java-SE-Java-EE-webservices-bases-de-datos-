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
		<form action="FrontController?option=doSeleccionCursoMatricular" method="Post">
		<%
			List<Alumno> alumnos=(List<Alumno>)request.getAttribute("alumnos");
		%>
		Alumno: <select name="usuario">
			
			<%
							for(Alumno alumno:alumnos){
						%>
				<option value="<%=alumno.getUsuario() %>">
					<%=alumno.getNombre() %>
				</option>
			<%} %>
			</select>
		<br/>
		<input type="submit" value="Siguiente"/>	
		</form>
		<br/><br/>
		
	</center>
</body>
</html>