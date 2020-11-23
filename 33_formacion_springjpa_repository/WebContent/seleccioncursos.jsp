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
		<form action="FrontController?option=doAlumnosCurso" method="Post">
		<%List<Curso> cursos=(List<Curso>)request.getAttribute("cursos"); %>
		Curso: <select name="idCurso">
			
			<%for(Curso curso:cursos){ %>
				<option value="<%=curso.getIdCurso() %>">
					<%=curso.getNombre() %>
				</option>
			<%} %>
			</select>
		<br/>
		<input type="submit" value="Buscar alumnos"/>	
		</form>
		<br/><br/>
		
	</center>
</body>
</html>