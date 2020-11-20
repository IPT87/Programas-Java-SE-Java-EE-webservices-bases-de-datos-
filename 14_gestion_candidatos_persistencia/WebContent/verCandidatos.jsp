<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, model.Candidato,service.CandidatosService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista candidatos</title>
</head>
<body style="font-family:verdana; background-color:powderblue;">
	<%
		CandidatosService service = new CandidatosService(); 
		  List<Candidato> candidatos = service.recuperarCandidatos();
	%>
	
	<%if(candidatos.size() == 0) { %>
		<center>
			<table border="5" bgcolor="lightblue" bordercolor="green">
			  <tr>
			    <th>Nombre</th>
			    <th>Edad</th>
			    <th>Puesto</th>
			    <th>Foto</th>
			    <th>Email</th>
			  </tr>
			 </table>
		 </center>
	<%} else { %>
	<center>
		<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="10" cellspacing="5">
		  <tr>
		    <th>Nombre</th>
		    <th>Edad</th>
		    <th>Puesto</th>
		    <th>Foto</th>
		    <th>Email</th>
		  </tr>
		  <%for(int i = 0; i < candidatos.size(); i++) { %>
		  <tr>
		    <td><%=candidatos.get(i).getNombre() %></td>
		    <td><%=candidatos.get(i).getEdad() %></td>
		    <td><%=candidatos.get(i).getPuesto() %></td>
		    <td><img alt="" height="170px" width="300px" src="<%=candidatos.get(i).getFoto() %>"></td>
		    <td><%=candidatos.get(i).getEmail() %></td>
		    <td><a href="Eliminar?idCandidato=<%=candidatos.get(i).getIdCandidato()%>">Eliminar</a></td>
		  </tr>
		  <%} %>
		</table>
	</center>
	<%} %>
	<br/><br/>
	<a href="inicio.html">Volver</a>
</body>
</html>