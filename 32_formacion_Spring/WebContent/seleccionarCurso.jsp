<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, model.Curso"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seleccionar curso</title>
</head>
<body>
	<form action="FrontController?option=toInicio" method="post" >	
		Seleccione curso<br/>
		<select name="curso">
			<%List<Curso> cursos = (List<Curso>)request.getAttribute("cursos");
			for(Curso curso : cursos){%>
			<option value="<%=curso.getNombre() %>"><%=curso.getNombre() %></option>
			<%} %>
		</select>
		<br/><br/>
		<p align="center"><input type="submit" value="Guardar"></p>
	</form>
	<p align="right"><a href="FrontController?option=toInicio">Volver al menu</a></p>
</body>
</html>