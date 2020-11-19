<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Candidato,service.CandidatosServiceImpl"%>
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
		<th>Nombre</th>
		<th>Edad</th>
		<th>Puesto</th>
		<th>Foto</th>
		<th>Email</th>
		<th></th>
	</tr>
		
			<%
						
						List<Candidato> empleados= (List<Candidato>)request.getAttribute("candidatos");
							for(int i=0;i<empleados.size();i++){
					%>
					<tr><td>
						<%=empleados.get(i).getNombre()%>
					</td>
					<td>
						<%=empleados.get(i).getEdad()%>
					</td>	
					<td>
						<%=empleados.get(i).getPuesto()%>					
					</td>
					<td>
						<%=empleados.get(i).getEmail()%>
						
					</td>
					<td>
						<img alt="" height="90px" width="140px" src="<%=empleados.get(i).getFoto()%>">
					
					</td>
					<td><a href="FrontController?option=doEliminarCandidato&idCandidato=<%=empleados.get(i).getIdCandidato()%>">Eliminar</a></td>
					</tr>
				<%}%>
	
	</table>
	<a href="FrontController?option=toMenu">Volver al menu</a>
</body>
</html>
