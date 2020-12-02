<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,model.Inscripcion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%List<Inscripcion> inscripciones = (List<Inscripcion>)request.getAttribute("inscripciones"); %>
	
	<%if(inscripciones.size() == 0) { %>
		<center>
			<table border="5" bgcolor="lightblue" bordercolor="green">
			  <tr>
			    <th>Empresa</th>
			    <th>Posicion</th>
			    <th>Salario</th>
			    <th>Candidato</th>
			  </tr>
			 </table>
		 </center>
	<%} else { %>
	<center>
		<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="10" cellspacing="5">
		  <tr>
		    <th>Empresa</th>
			<th>Posicion</th>
			<th>Salario</th>
			<th>Candidato</th>
		  </tr>
		  <%for(int i = 0; i < inscripciones.size(); i++) { %>
		  <tr>
		    <td><%=inscripciones.get(i).getEmpresa() %></td>
		    <td><%=inscripciones.get(i).getPosicion() %></td>
		    <td><%=inscripciones.get(i).getSalario() %></td>
		    <td><%=inscripciones.get(i).getCandidato().getNombre() %></td>
		  </tr>
		  <%} %>
		</table>
	</center>
	<%} %>
	<br/><br/>
	<a href="FrontController?option=toMenu">Volver</a>
</body>
</html>