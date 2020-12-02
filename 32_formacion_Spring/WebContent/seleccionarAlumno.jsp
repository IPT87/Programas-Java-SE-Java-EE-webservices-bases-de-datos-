<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,model.Alumno"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seleccionar alumno</title>
</head>
<body>
	<form action="FrontController?option=doVerCursos" method="post" >	
		Seleccione alumno<br/>
		<select name="alumno">
			<%
				List<Alumno> alumnos = (List<Alumno>)request.getAttribute("alumnos");
				for(Alumno alumno : alumnos){
			%>
			<option value="<%=alumno.getUsuario() %>"><%=alumno.getUsuario() %></option>
			<%} %>
		</select>
		<br/><br/>
		<p align="center"><input type="submit" value="Siguente"></p>
	</form>
	<p align="right"><a href="FrontController?option=toInicio">Volver al menu</a></p>
</body>
</html>