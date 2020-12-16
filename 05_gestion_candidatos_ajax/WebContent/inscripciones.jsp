<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	table,tr,th,td {
		border:1px solid pink;
	}
</style>
</head>
<body>
	<table>
	<tr>
		<th>Empresa</th>
		<th>Posicion</th>
		<th>Salario</th>
		<th>Empleado</th>
		
	</tr>
		
			<%
						
						List<Inscripcion> inscripciones= (List<Inscripcion>)request.getAttribute("inscripciones");
							for(Inscripcion ins:inscripciones){
					%>
					<tr><td>
						<%=ins.getEmpresa()%>
					</td>
					<td>
						<%=ins.getPosicion()%>
					</td>	
					<td>
						<%=ins.getSalario()%>					
					</td>
					<td>
						<%=ins.getCandidato().getNombre()%>
						
					</td>
					
					</tr>
				<%}%>
	
	</table>
	<a href="FrontController?option=toMenu">Volver al menu</a>
</body>
</html>
