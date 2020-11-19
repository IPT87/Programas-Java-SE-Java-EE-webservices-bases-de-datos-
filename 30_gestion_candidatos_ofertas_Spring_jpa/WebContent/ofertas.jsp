<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FrontController?option=doAltaInscripcion" method="post" >	
		Empresa<br/>
		<input type="text" name="empresa" placeholder="Introduce empresa" required="required">
		<br/>
		Posicion<br/>
		<input type="text" name="posicion" placeholder="Introduce posicion" required="required">
		<br/>
		Salario<br/>
		<input type="text" name="salario" placeholder="Introduce salario" required="required">
		<br/><br/>
		Candidato <select name="idCandidato">
			<%List<Candidato> candidatos=(List<Candidato>)request.getAttribute("candidatos");
			for(Candidato candidato:candidatos){%>
			<option value="<%=candidato.getIdCandidato()%>"><%=candidato.getNombre()%></option>
			<%} %>
		</select>
		<br/><br/>
		<input type="submit" value="Guardar">	
	</form>
	<p align="right"><a href="FrontController?option=toMenu">Volver al menu</a></p>
</body>
</html>