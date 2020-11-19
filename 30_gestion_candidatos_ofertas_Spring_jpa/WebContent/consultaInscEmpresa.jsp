<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FrontController?option=doBuscarCandidatoPorOfertaEmpresa" method="post" >	
		Empresa <select name="nombreEmpresa">
			<%List<String> empresas = (List<String>)request.getAttribute("empresas");
			for(String empresa : empresas){%>
			<option value="<%=empresa%>"><%=empresa%></option>
			<%} %>
		</select>
		<br/><br/>
		<input type="submit" value="Ver candidatos">	
	</form>
	<p align="right"><a href="FrontController?option=toMenu">Volver al menu</a></p>
</body>
</html>